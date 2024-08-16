package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Linea extends Grafica {

    private float posx2;
    private float posy2;



    public Linea(String nombre, Animacion animacion, float posx, float posy, String color, float posx2, float posy2 ) {
        super(nombre, animacion, posx, posy, color);

        this.posx2 = posx2;
        this.posy2 = posy2;
    }
    
}
