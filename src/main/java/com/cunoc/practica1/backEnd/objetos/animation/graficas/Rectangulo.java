package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Rectangulo extends Grafica {

    private Double ancho;
    private Double alto;


    public Rectangulo(String nombre, Animacion animacion, double posx, double posy, String color,Double ancho, Double alto) {
        super(nombre, animacion, posx, posy, color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    
}
