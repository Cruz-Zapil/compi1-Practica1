package com.cunoc.practica1.backEnd.objetos.animation;

public class Animacion {

    private String tipoAnimacion;
    private float destinoX;
    private float destinoY;
    private float orden;

    public Animacion(String tipoAnimacion, float destinoX, float destinoY, float orden) {
        this.tipoAnimacion = tipoAnimacion;
        this.destinoX = destinoX;
        this.destinoY = destinoY;
        this.orden = orden;
    }

    public String getTipoAnimacion() {
        return tipoAnimacion;
    }

    public void setTipoAnimacion(String tipoAnimacion) {
        this.tipoAnimacion = tipoAnimacion;
    }

    public float getDestinoX() {
        return destinoX;
    }

    public void setDestinoX(int destinoX) {
        this.destinoX = destinoX;
    }

    public float getDestinoY() {
        return destinoY;
    }

    public void setDestinoY(int destinoY) {
        this.destinoY = destinoY;
    }

    public float getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    
    
}
