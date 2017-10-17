#include "sensor.h"
#include "network.h"

static TaskHandle_t task = NULL;
static xQueueHandle gpio_evt_queue = NULL;

static void IRAM_ATTR gpio_isr_handler(void* arg)
{
    uint32_t gpio_num = (uint32_t) arg;
    xQueueSendFromISR(gpio_evt_queue, &gpio_num, NULL);
}

typedef struct sens sens;

struct sens{
    uint64_t d_time;
    uint64_t f_time;
};

void calculate(sens * sensors){
    if(fabs(sensors[1].d_time - sensors[0].d_time) > EPS_MEASURE) return;
    int dt = sensors[1].f_time - sensors[0].f_time;
    int t_block = (sensors[1].d_time + sensors[0].d_time)/2;
    char* payload = (char*)malloc(sizeof(char)*50);
    double speed = ((double)SENSOR_DISTANCE) * 1000 /dt; //[cm/s]
    double length = speed * t_block / 1000;
    sprintf(payload, "speed: %010.3lfcm/s length: %010.3lfcm\n", speed, length);
    mqtt_write(payload);
}


static void sensor() {  
    init_sensor();
    
    uint8_t level[2], last_level[2] = {0, 0};
    uint64_t time[2] = {0, 0};
    uint32_t io_num;
    uint8_t id;

    uint8_t a = 0;

    sens sensors[2];
    
    while (1){
        if(xQueueReceive(gpio_evt_queue, &io_num, portMAX_DELAY)) {
            id = getId(io_num);
            level[id] = gpio_get_level(io_num);
            if(clock() - time[id] > EPS){
                
                switch(level[id] - last_level[id]){
                    case -1: //LOW vezérlés esetén jön a vonat
                        sensors[id].f_time = clock() * 1000 / CLOCKS_PER_SEC;
                        break;
                    case 1:
                        sensors[id].d_time = clock() * 1000 / CLOCKS_PER_SEC - sensors[id].f_time;
                        printf("%d\n", (int)sensors[id].d_time);
                        if(a != id) calculate(sensors);
                        a = id;
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