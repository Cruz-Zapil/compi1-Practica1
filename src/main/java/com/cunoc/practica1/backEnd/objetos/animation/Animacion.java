package com.cunoc.practica1.backEnd.objetos.animation;

public class Animacion {

    private String tipoAnimacion;
    private Double destinoX;
    private Double destinoY;
    private Double orden;

    public Animacion(String tipoAnimacion, Double dx, Double dy, Double or) {
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

    public Double getDestinoX() {
        return destinoX;
    }

    public void setDestinoX(Double destinoX) {
        this.destinoX = destinoX;
    }

    public Double getDestinoY() {
        return destinoY;
    }

    public void setDestinoY(Double destinoY) {
        this.destinoY = destinoY;
    }

    public Double getOrden() {
        return orden;
    }

    public void setOrden(Double orden) {
        this.orden = orden;
    }

   
    
}
