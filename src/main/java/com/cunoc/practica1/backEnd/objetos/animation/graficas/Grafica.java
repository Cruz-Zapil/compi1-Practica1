package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Grafica {

    private String nombre;
    private Animacion animacion;
    private double posx;
    private double posy;
    private String color;

    
    public Grafica(String nombre, Animacion animacion, double posx, double posy, String color) {
        this.nombre = nombre;
        this.animacion = animacion;
        this.posx = posx;
        this.posy = posy;
        this.color = color;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Animacion getAnimacion() {
        return animacion;
    }


    public void setAnimacion(Animacion animacion) {
        this.animacion = animacion;
    }


    public double getPosx() {
        return posx;
    }


    public void setPosx(int posx) {
        this.posx = posx;
    }


    public double getPosy() {
        return posy;
    }


    public void setPosy(int posy) {
        this.posy = posy;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }



    
}
