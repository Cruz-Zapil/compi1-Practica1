package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;
import java.awt.Graphics2D;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Rectangulo extends Grafica {

    private double ancho;
    private double alto;


    public Rectangulo(String nombre, Animacion animacion, double posx, double posy, Color color,double ancho, double alto) {
        super(nombre, animacion, posx, posy, color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    @Override
    public void dibujar(Graphics2D g) {

        g.setColor(super.getColor());
        g.fillRect((int)super.getPosx() , (int)super.getPosy() , (int)ancho, (int)alto);
    }
    
}
