package com.cunoc.practica1.frontEnd.paneles.panelGrafico;



import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;



public class PanelGrafico extends JPanel{

   
    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillRect(10, 10, 100, 100);
    }

}
