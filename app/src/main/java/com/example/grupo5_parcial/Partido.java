package com.example.grupo5_parcial;

import java.io.Serializable;

public class Partido implements Serializable {
    private String nombreRival;
    private int golesRival;
    private String urlEscudoRival;
    private int golesEquipo;

    public Partido (){}

    public Partido(String nombreRival, int golesRival, String urlEscudoRival, int golesEquipo) {
        this.nombreRival = nombreRival;
        this.golesRival = golesRival;
        this.urlEscudoRival = urlEscudoRival;
        this.golesEquipo = golesEquipo;
    }

    public String getNombreRival() {
        return nombreRival;
    }

    public void setNombreRival(String nombreRival) {
        this.nombreRival = nombreRival;
    }

    public int getGolesRival() {
        return golesRival;
    }

    public void setGolesRival(int golesRival) {
        this.golesRival = golesRival;
    }

    public String getUrlEscudoRival() {
        return urlEscudoRival;
    }

    public void setUrlEscudoRival(String urlEscudoRival) {
        this.urlEscudoRival = urlEscudoRival;
    }

    public int getGolesEquipo() {
        return golesEquipo;
    }

    public void setGolesEquipo(int golesEquipo) {
        this.golesEquipo = golesEquipo;
    }
}
