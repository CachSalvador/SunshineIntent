package com.example.salvador.sunshineintent;

import java.io.Serializable;

/**
 * Created by Salvador on 27/05/2015.
 */
public class ClimaBean implements Serializable{
    private String dia;
    private String temperatura;
    private String clima;
    private int imagen;



    public ClimaBean(String dia, String temperatura, String clima, int imagen) {
        this.dia = dia;
        this.temperatura = temperatura;
        this.clima = clima;
        this.imagen = imagen;
    }

    public ClimaBean() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int clima) {
        this.imagen = imagen;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }


}
