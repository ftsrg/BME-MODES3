#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/queue.h"
#include "driver/gpio.h"
#include "time.h"


#define GPIO_INPUT_IO_0     13
#define GPIO_INPUT_IO_1     27
#define GPIO_INPUT_PIN_SEL  ((1<<GPIO_INPUT_IO_0) | (1<<GPIO_INPUT_IO_1))
#define ESP_INTR_FLAG_DEFAULT 0
#define EPS 20
#define EPS_MEASURE 20
#define SENSOR_DISTANCE 7

static void IRAM_ATTR gpio_isr_handler(void*);
static void sensor();
void start_sensor();
void init_sensor();
uint8_t getId(uint32_t);
void calculate(uint64_t*);
uint8_t is_full(uint64_t);