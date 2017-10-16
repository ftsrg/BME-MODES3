#include "sensor.h"
#include "network.h"

static TaskHandle_t task = NULL;
static xQueueHandle gpio_evt_queue = NULL;

static void IRAM_ATTR gpio_isr_handler(void* arg)
{
    uint32_t gpio_num = (uint32_t) arg;
    xQueueSendFromISR(gpio_evt_queue, &gpio_num, NULL);
}

uint64_t * carriages; // 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
                      // |=========1. sensor times=========| |=========0. sensor times=========|
                      // |t__out| |t__out| |tstart| |tstart| |t__out| |t__out| |tstart| |tstart|

void calculate(uint64_t *carriage){
    uint16_t t_out[2];
    uint16_t t_start[2];
    for(int i = 0; i<2; i++){
        t_out[i] = (*carriage>>((2*i + 1) * 16));
        t_start[i] = (*carriage>>((2*i) * 16));
        
    }
    *carriage = 0;

    if(fabs(t_out[1] - t_out[0]) > EPS_MEASURE) return;
    uint8_t dt = fabs(t_start[1] - t_start[0]);
    uint8_t t_block = (t_out[1] + t_out[0])/2;
    char* payload = (char*)malloc(sizeof(char)*50);
    double speed = ((double)SENSOR_DISTANCE) * 100 /dt;
    double length = speed * t_block / 100;
    sprintf(payload, "speed: %010.3lfcm/s length: %010.3lfcm\n", speed, length); 
    mqtt_write(payload, "test");
}


static void sensor() {  
    init_sensor();
    
    uint8_t level[2], last_level[2] = {1, 1};
    uint64_t time[2] = {0, 0};
    uint32_t io_num;
    uint8_t id;

    carriages = (uint64_t*)malloc(sizeof(uint64_t)*5);
    for(int i = 0; i<5; i++)carriages[i] = 0;
    uint8_t i = 0;
    
    while (1){
        if(xQueueReceive(gpio_evt_queue, &io_num, portMAX_DELAY)) {
            id = getId(io_num);
            level[id] = gpio_get_level(io_num);
            if(clock() - time[id] > EPS){
                
                switch(level[id] - last_level[id]){
                    case -1: //LOW vezérlés esetén jön a vonat
                        i = 0;
                        while(carriages[i] & ((uint64_t)((1<<16) - 1)<<(2*id*16))) i++;
                        carriages[i] |= ((uint64_t)(clock() * 100 / CLOCKS_PER_SEC)) << (2*id*16); //shifting the current time (on 16 bits) to its correct place (in 'centiseconds') -> max is reached after cca 10 minutes
                        break;
                    case 1:
                        i = 0;
                        while(carriages[i] & ((uint64_t)((1<<16) - 1)<<((2*id+1)*16))) i++;
                        carriages[i] |= ((uint64_t)(clock() * 100 / CLOCKS_PER_SEC - (uint64_t)((carriages[i] & ((uint64_t)((1<<16) - 1)<<(2*id*16)))>>(2*id*16)))) << ((2*id+1)*16); //shifting the time difference (on 16 bits) to its correct place
                        if(is_full(carriages[i])) calculate(&(carriages[i]));
                        break;
                    default:
                        break;
                }
                time[id] = clock();
                last_level[id] = level[id];
            }
            
        }
    }
}

uint8_t is_full(uint64_t carriage)
{
    for(int i = 0; i<4; i++){
        if(!(uint16_t)(carriage>>i*16)) return 0;
    }
    return 1;
}

uint8_t getId(uint32_t pin){
    switch(pin){
        case GPIO_INPUT_IO_0:
            return 0;
            break;
        case GPIO_INPUT_IO_1:
            return 1;
            break;
    }
    return -1;
}


void start_sensor(TaskHandle_t* task){
    xTaskCreatePinnedToCore(sensor, "sensor", 8192, NULL, 10, task, 0);
}

void init_sensor(){
    gpio_config_t io_conf;
    io_conf.pin_bit_mask = GPIO_INPUT_PIN_SEL;
    io_conf.mode = GPIO_MODE_INPUT;
    io_conf.pull_up_en = 1;
    gpio_config(&io_conf);
    gpio_set_intr_type(GPIO_INPUT_IO_0, GPIO_INTR_ANYEDGE);
    gpio_set_intr_type(GPIO_INPUT_IO_1, GPIO_INTR_ANYEDGE);
    gpio_evt_queue = xQueueCreate(10, sizeof(uint32_t));
    gpio_install_isr_service(ESP_INTR_FLAG_DEFAULT);
    gpio_isr_handler_add(GPIO_INPUT_IO_0, gpio_isr_handler, (void*) GPIO_INPUT_IO_0);
    gpio_isr_handler_add(GPIO_INPUT_IO_1, gpio_isr_handler, (void*) GPIO_INPUT_IO_1);
}