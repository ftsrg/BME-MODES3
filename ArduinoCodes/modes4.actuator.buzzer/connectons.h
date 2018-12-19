
#define LABWIFI


#ifdef LABWIFI
       char* ssid     = "Container";
       char* password = "LaborImage";
       char* host = "192.168.1.239";
#endif
#ifdef LABORWIFI
       char* ssid     = "MoDeS3";
       char* password = "LaborImage";
       char* host = "192.168.1.239";
#endif
#ifdef OTTHONWIFI
       char* ssid     = "VargaK";
       char* password = "14Basipa";
      const char* host = "192.168.1.239";
#endif
#ifdef UTIWIFI
       char* ssid     = "HungarianWiFi";
       char* password = "flower01";
       char* host = "192.168.43.199";
#endif



WiFiClient espClient;



void setup_wifi() {

  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  randomSeed(micros());

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}




