package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Poligono extends Grafica{


    private double cantLado;
    private double ancho;
    private double alto;

    
    public Poligono(String nombre, Animacion animacion, Double posx, Double posy, String color,Double cl, Double l, Double h) {
        super(nombre, animacion, posx, posy, color);

        this.cantLado = cl;
        this.ancho = l;
        this.alto = h;
        
    }

    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    
}
