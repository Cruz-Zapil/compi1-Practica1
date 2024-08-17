package com.cunoc.practica1.backEnd.objetos.animation.graficas;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Linea extends Grafica {

    private Double posx2;
    private Double posy2;



    public Linea(String nombre, Animacion animacion, Double posx, Double posy, String color, Double posx22, Double posy22 ) {
        super(nombre, animacion, posx, posy, color);

        this.posx2 = posx22;
        this.posy2 = posy22;
    }
    
    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

}
