/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Leituras{
    private String umidade;
    private String temperatura;
    private String precipitacao;
    private String dataHora;
    
    public Leituras(String umidade, String temperatura, String precipitacao, String dataHora) {
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
        this.dataHora = dataHora;
    }

    public String getUmidade() { return umidade; }
    public String getTemperatura() { return temperatura; }
    public String getPrecipitacao() { return precipitacao; }
    public String getDataHora() { return dataHora; }
}