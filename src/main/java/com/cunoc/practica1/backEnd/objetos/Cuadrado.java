package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;
import java.awt.Graphics2D;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Cuadrado extends Grafica{

    private double lado;

    public Cuadrado(String nombre, Animacion animacion, Double posx, Double posy, Color color, Double l) {
        super(nombre, animacion, posx, posy, color);
       
        this.lado = l;
        
    }


    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    @Override
    public void dibujar(Graphics2D g) {
        
        g.setColor(super.getColor());
        g.fillRect((int)super.getPosx() , (int)super.getPosy() , (int)lado, (int)lado);
    }

    
    
}
