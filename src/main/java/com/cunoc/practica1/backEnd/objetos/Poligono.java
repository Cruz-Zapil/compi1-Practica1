package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;
import java.awt.Graphics;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Poligono extends Grafica{


    private double cantLado;
    private double ancho;
    private double alto;

    
    public Poligono(String nombre, Animacion animacion, Double posx, Double posy, Color color,Double cl, Double l, Double h) {
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

    public void dibujar(Graphics g){
        g.setColor(super.getColor());
        int[] xpoint= new int[(int)cantLado];
        int[] ypoint= new int[(int)cantLado];
        g.drawPolyline(xpoint, ypoint, (int)cantLado);
        
    }

    
}
