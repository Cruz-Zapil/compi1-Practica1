package com.cunoc.practica1.backEnd.objetos;

import java.awt.Color;
import java.awt.Graphics2D;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

public class Linea extends Grafica {

    private double posx2;
    private double posy2;



    public Linea(String nombre, Animacion animacion, Double posx, Double posy, Color color, Double posx22, Double posy22 ) {
        super(nombre, animacion, posx, posy, color);

        this.posx2 = posx22;
        this.posy2 = posy22;
    }
    
    public double getPosx2() {
        return posx2;
    }

    public void setPosx2(double posx2) {
        this.posx2 = posx2;
    }

    public double getPosy2() {
        return posy2;
    }

    public void setPosy2(double posy2) {
        this.posy2 = posy2;
    }

    @Override
    public void setAnimacion(Animacion animacion) {
        System.out.println(" animacion agregada "+ super.getNombre());
        super.setAnimacion(animacion);
    }

    @Override
    public void dibujar(Graphics2D g){
        g.setColor(super.getColor());
        g.drawLine((int)super.getPosx() , (int)super.getPosy() , (int)posx2, (int)posy2);
    }

}
