package com.cunoc.practica1.backEnd.objetos.animation;

public class Animacion {

    private String tipoAnimacion;
    private double destinoX;
    private double destinoY;
    private double orden;

    public Animacion(String tipoAnimacion, double dx, double dy, double or) {
        this.tipoAnimacion = tipoAnimacion;
        this.destinoX = dx;
        this.destinoY = dy;
        this.orden = or;
    }

    public String getTipoAnimacion() {
        return tipoAnimacion;
    }

    public void setTipoAnimacion(String tipoAnimacion) {
        this.tipoAnimacion = tipoAnimacion;
    }

    public double getDestinoX() {
        return destinoX;
    }

    public void setDestinoX(Double destinoX) {
        this.destinoX = destinoX;
    }

    public double getDestinoY() {
        return destinoY;
    }

    public void setDestinoY(Double destinoY) {
        this.destinoY = destinoY;
    }

    public double getOrden() {
        return orden;
    }

    public void setOrden(Double orden) {
        this.orden = orden;
    }

   
    
}
