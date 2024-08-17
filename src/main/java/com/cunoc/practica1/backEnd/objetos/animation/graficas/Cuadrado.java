package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Cuadrado extends Grafica{

    private double lado;

    public Cuadrado(String nombre, Animacion animacion, Double posx, Double posy, String color, Double l) {
        super(nombre, animacion, posx, posy, color);
       
        this.lado = l;
        
    }


    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    
    
}
