#include <CurieBLE.h>
#include <CurieIMU.h>

BLEPeripheral blePeripheral;
BLEService sensorService("19B10000-E8F2-537E-4F6C-D104768A1214");

BLEIntCharacteristic accX("6B11EBD2-B68E-4AE0-B1FF-A5955EE651F1", BLERead);
BLEIntCharacteristic accY("88AF69D0-1B19-41F7-BFF8-C72066596967", BLERead);
BLEIntCharacteristic accZ("2BE01F11-F7DF-46DC-A1AC-6A4002E6BD29", BLERead);
BLEIntCharacteristic gyrX("ED69E5A0-7218-424A-A7B4-A3FEAC99CBCF", BLERead);
BLEIntCharacteristic gyrY("0DF52FBB-5ADC-439F-893B-FD447E72B81E", BLERead);
BLEIntCharacteristic gyrZ("98048C79-7AF0-457F-95ED-0088A795CFF9", BLERead);

const int ledPin = 13; // pin to use for the LED

void setup() {
  pinMode(ledPin, OUTPUT);
  Serial.begin(115200);

  blePeripheral.setLocalName("SNCF-Sensor");
  blePeripheral.setAdvertisedServiceUuid(sensorService.uuid());

  blePeripheral.addAttribute(sensorService);
  blePeripheral.addAttribute(accX);
  blePeripheral.addAttribute(accY);
  blePeripheral.addAttribute(accZ);
  blePeripheral.addAttribute(gyrX);
  blePeripheral.addAttribute(gyrY);
  blePeripheral.addAttribute(gyrZ);

  digitalWrite(ledPin, HIGH);
  delay(100);
  digitalWrite(ledPin, LOW);
  delay(100);

  // begin advertising BLE service:
  blePeripheral.begin();

  digitalWrite(ledPin, HIGH);
  delay(100);
  digitalWrite(ledPin, LOW);

  CurieIMU.begin();
}

void loop() {
  int ax, ay, az, gx, gy, gz;
  CurieIMU.readMotionSensor(ax, ay, az, gx, gy, gz);
  
  Serial.print("AX: ");
  Serial.print(ax);
  Serial.print(" AY: ");
  Serial.print(ay);
  Serial.print(" AZ: ");
  Serial.print(az);

  Serial.print("| GX: ");
  Serial.print(gx);
  Serial.print(" GY: ");
  Serial.print(gy);
  Serial.print(" GZ: ");
  Serial.print(gz);

  accX.setValue(ax);
  accY.setValue(ay);
  accZ.setValue(az);

  gyrX.setValue(gx);
  gyrY.setValue(gy);
  gyrZ.setValue(gz);
}

