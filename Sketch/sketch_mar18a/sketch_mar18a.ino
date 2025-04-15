#include <DHT.h>
#include <DHT_U.h>

#define DHTPIN 2
#define DHTTYPE DHT11
#define pinSensorD 8

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin(); 
  pinMode(pinSensorD, INPUT); 
}

float umidade;
float temperatura;
String precipitacao;

void loop() {

  temperatura = dht.readTemperature();
  umidade = dht.readHumidity();
  precipitacao = digitalRead(pinSensorD) ? "SEM CHUVA" : "ESTA CHOVENDO";

  if (isnan(temperatura) || isnan(umidade)) {
    Serial.println("Falha ao ler do sensor DHT!");
    return;
  }
  
  Serial.print(umidade);
  Serial.print(",");

  Serial.print(temperatura);
  Serial.print(",");
  
  Serial.print(precipitacao);
  Serial.println(",");

  Serial.println();
  delay(2000);
}