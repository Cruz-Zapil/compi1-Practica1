package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Poligono extends Grafica{


    private float cantLado;
    private float ancho;
    private float alto;

    
    public Poligono(String nombre, Animacion animacion, float posx, float posy, String color,float cantLado, float ancho, float alto) {
        super(nombre, animacion, posx, posy, color);

        this.cantLado = cantLado;
        this.ancho = ancho;
        this.alto = alto;
        
    }
    
}
