package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;

import java.awt.Graphics2D;

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

    @Override
    public void dibujar(Graphics2D g){
        g.setColor(super.getColor());


        int centroX = (int) this.getPosx();
        int centroY = (int) this.getPosy();
        int lados = (int) this.cantLado;

        int width = (int) this.ancho;
        int height = (int) this.alto;

        int[] xpoint= new int[(int)cantLado];
        int[] ypoint= new int[(int)cantLado];

        for (int i = 0; i < lados; i++) {
            xpoint[i] = (int) (centroX + width * Math.cos(2 * Math.PI * i / lados));
            ypoint[i] = (int) (centroY + height * Math.sin(2 * Math.PI * i / lados));
        }
        g.fillPolygon(xpoint, ypoint, (int)cantLado);
        
    }

    
}
