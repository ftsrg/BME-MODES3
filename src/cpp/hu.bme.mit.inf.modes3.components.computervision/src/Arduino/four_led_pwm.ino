int LED_1_PIN = 3;
int LED_2_PIN = 5;
int LED_3_PIN = 6;
int LED_4_PIN = 9;

int led_1_value = 0; // 0 - 255 | always off - always on
int led_2_value = 0; // 0 - 255 | always off - always on
int led_3_value = 0; // 0 - 255 | always off - always on
int led_4_value = 0; // 0 - 255 | always off - always on

String inputString = "";         // a string to hold incoming data
boolean stringComplete = false;  // whether the string is complete

void setup() {
  // Init serial
  Serial.begin(115200);
  
  // Init output pins
  pinMode(LED_1_PIN, OUTPUT);
  pinMode(LED_2_PIN, OUTPUT);
  pinMode(LED_3_PIN, OUTPUT);
  pinMode(LED_4_PIN, OUTPUT);
  
  // Init pwm signals
  setPWMSignal(1, led_1_value); 
  setPWMSignal(2, led_2_value);
  setPWMSignal(3, led_3_value);
  setPWMSignal(4, led_4_value);
  
  Serial.println("Enter value (Syntx: LED_NUM VALUE, where LED_NUM: 1-4 and VALUE: 0-255):");
  
}

void loop() {
  // print the string when a newline arrives:
  if (stringComplete) {
    int value = getValueFromCommand(inputString);
    int ledNum = getLedNumFromCommand(inputString);
    setPWMSignal(ledNum, value);
    
    // clear the string:
    inputString = "";
    stringComplete = false;
  }
}

void setPWMSignal(int ledNum, int value){
    int pin = -1;
    
    if(value >= 0 && value <= 255){
      switch(ledNum){
        case 1: pin = LED_1_PIN; 
                break;
        case 2: pin = LED_2_PIN; 
                break;
        case 3: pin = LED_3_PIN; 
                break;
        case 4: pin = LED_4_PIN; 
                break;
        default: return;
                 break;
      }
      analogWrite(pin, value);
      // Serial.println("Led_" + String(ledNum) + " (pin" + String(pin) + ")" + " set to " + String(value));
    }
}

int getValueFromCommand(String command){
  int spaceIndex = command.indexOf(' ');
  if(spaceIndex != -1){
    String valueStr = command.substring(spaceIndex + 1, command.length());
    int value = valueStr.toInt();
    if(value >= 0 && value <= 255){
      return value;
    }
    //Serial.println("Invalid value: " + valueStr + " shall be 0-255!");
  }
  
  return -1;
}

int getLedNumFromCommand(String command){
  int spaceIndex = command.indexOf(' ');
  if(spaceIndex != -1){
    String ledNumStr = command.substring(0, spaceIndex + 1);
    int ledNum = ledNumStr.toInt();
    if(ledNum >= 1 && ledNum <= 4){
      return ledNum;
    }
    //Serial.println("Invalid led number: " + ledNumStr + " shall be 1-4!");
  }
  return 0;
}

/*
  SerialEvent occurs whenever a new data comes in the
 hardware serial RX.  This routine is run between each
 time loop() runs, so using delay inside loop can delay
 response.  Multiple bytes of data may be available.
 */
void serialEvent() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    // if the incoming character is a newline, set a flag
    // so the main loop can do something about it:
    if (inChar == '\n') {
      stringComplete = true;
    }
  }
}
