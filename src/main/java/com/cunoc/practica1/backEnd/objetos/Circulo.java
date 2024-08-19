package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;
import java.awt.Graphics2D;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;


public class Circulo extends Grafica{


    private double radio;

    public Circulo(String nombre, Animacion animacion, Double posx, Double posy, Color color, double r) {
        super(nombre, animacion, posx, posy, color);
        this.radio =r;
    
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    @Override
    public void dibujar(Graphics2D g){
        g.setColor(super.getColor());
        g.fillOval((int)super.getPosx() , (int)super.getPosy() , (int)radio, (int)radio);
    }
    
}
