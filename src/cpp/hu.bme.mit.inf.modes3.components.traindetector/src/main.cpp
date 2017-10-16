#include <iostream>

extern "C" { 
    #include "soc/timer_group_struct.h" 
}

#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/queue.h"
#include "driver/periph_ctrl.h"
#include "driver/timer.h"
#include "driver/adc.h"

#include "sdkconfig.h"
#include "traindetector.h"
#include "edgedetector.h"

xQueueHandle sampleQueue;

volatile int isrCounter = 0;

typedef struct {
    int timestamp;
    int leftVoltage;
    int rightVoltage;
} SampleItem;

static auto edgeToString = [](td::EdgeDirection edgeDir){
    switch (edgeDir) {
        case td::FALLING:
            return "FALLING";
        case td::RISING:
            return "RISING";
        case td::NOEDGE:
            return "NOEDGE";
    }
    return "OHNONONO";
};

static auto quantitize = [](int voltage){
    return voltage < 1750 ? td::LOW : td::HIGH;
};

void IRAM_ATTR timerISR(void *para)
{
    /*Timer1 is an example that will reload counter value*/
    TIMERG0.hw_timer[0].update = 1;
    /*We don't call a API here because they are not declared with IRAM_ATTR*/
    TIMERG0.int_clr_timers.t0 = 1;
    /*For a auto-reload timer, we still need to set alarm_en bit if we want to enable alarm again.*/
    TIMERG0.hw_timer[0].config.alarm_en = 1;

    SampleItem sample;
    sample.leftVoltage = adc1_get_voltage(ADC1_CHANNEL_6);
    sample.rightVoltage = adc1_get_voltage(ADC1_CHANNEL_7);
    sample.timestamp = isrCounter;
    xQueueSendFromISR(sampleQueue, &sample, NULL);

    isrCounter++;
}

void samplingTask(void *pvParameter)
{
    td::TrainDetector trainDetector;
    td::EdgeDetector rightEdgeDetector;
    td::EdgeDetector leftEdgeDetector;

    SampleItem currentSample, previousSample;
    for (;;) {
        xQueueReceive(sampleQueue, &sample, portMAX_DELAY);

        td::SignalLevel rightLevel = quantitize(sample.rightVoltage);
        td::EdgeDirection rightEdge = rightEdgeDetector.detectEdge(rightLevel);
        if (rightEdge != td::NOEDGE) {
            trainDetector.handleEdge(td::RIGHT, rightEdge, xTaskGetTickCount());
        }
        
        td::SignalLevel leftLevel = quantitize(sample.leftVoltage);
        td::EdgeDirection leftEdge = leftEdgeDetector.detectEdge(leftLevel);
        if (leftEdge != td::NOEDGE) {
            trainDetector.handleEdge(td::LEFT, leftEdge, xTaskGetTickCount());
        }

        std::cout << sample.timestamp << ": ";
        std::cout << "R: " << sample.rightVoltage << "/" << rightLevel << ", ";
        std::cout << "L: " << sample.leftVoltage << "/" << leftLevel << " = ";
        std::cout << edgeToString(rightEdge) << " " << edgeToString(leftEdge) << std::endl;
    }
}

extern "C" void app_main()
{
    sampleQueue = xQueueCreate(10, sizeof(SampleItem));
    xTaskCreate(&samplingTask, "sampling_task", 4096, NULL, 5, NULL);

    adc1_config_width(ADC_WIDTH_12Bit);
    adc1_config_channel_atten(ADC1_CHANNEL_6, ADC_ATTEN_11db);
    adc1_config_channel_atten(ADC1_CHANNEL_7, ADC_ATTEN_11db);

    timer_config_t timer0_config = {
        .alarm_en = true,
        .counter_en = TIMER_PAUSE,
        .intr_type = TIMER_INTR_LEVEL,
        .counter_dir = TIMER_COUNT_UP,
        .auto_reload = true,
        .divider = 8
    };
    timer_init(TIMER_GROUP_0, TIMER_0, &timer0_config);
    timer_enable_intr(TIMER_GROUP_0, TIMER_0);
    timer_isr_register(TIMER_GROUP_0, TIMER_0, timerISR, NULL, ESP_INTR_FLAG_IRAM, NULL);
    timer_set_counter_value(TIMER_GROUP_0, TIMER_0, 0);
    timer_set_alarm_value(TIMER_GROUP_0, TIMER_0, 10000);
    timer_start(TIMER_GROUP_0, TIMER_0);
}