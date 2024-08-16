package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Cuadrado extends Grafica{

    private float lado;

    public Cuadrado(String nombre, Animacion animacion, float posx, float posy, String color, float lado) {
        super(nombre, animacion, posx, posy, color);
       
        this.lado = lado;
        
    }
    
}
