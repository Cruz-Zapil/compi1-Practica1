package com.cunoc.practica1.backEnd.objetos;

import com.cunoc.practica1.backEnd.objetos.animation.Animacion;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Grafica {

    private String nombre;
    protected Animacion animacion;
    private double posx;
    private double posy;
    private Color color;

    
    public Grafica(String nombre, Animacion animacion, double posx, double posy, Color color) {
        this.nombre = nombre;
        this.animacion = animacion;
        this.posx = posx;
        this.posy = posy;
        this.color = color;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Animacion getAnimacion() {
        return animacion;
    }


    public void setAnimacion(Animacion animacion) {
        this.animacion = animacion;
    }


    public double getPosx() {
        return posx;
    }


    public void setPosx(int posx) {
        this.posx = posx;
    }


    public double getPosy() {
        return posy;
    }


    public void setPosy(int posy) {
        this.posy = posy;
    }


    public void setPosx(double posx) {
        this.posx = posx;
    }


    public void setPosy(double posy) {
        this.posy = posy;
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public void dibujar(Graphics2D g) {};

    public void mover(int x, int y ){
        System.out.println("moviendo ");
        if (animacion!=null){
            System.out.println("animacion activada");
            this.posx= x;
            this.posy = y;
        }
    }



    
}
