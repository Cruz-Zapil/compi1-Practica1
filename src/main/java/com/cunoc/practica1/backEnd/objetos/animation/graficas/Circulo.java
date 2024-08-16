package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Circulo extends Grafica{


    private Double radio;

    public Circulo(String nombre, Animacion animacion, Double posx, Double posy, String color, Double r) {
        super(nombre, animacion, posx, posy, color);

        this.radio =r;
    
    }

    
}
