package com.cunoc.practica1.frontEnd.paneles.panelGrafico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import com.cunoc.practica1.backEnd.objetos.Grafica;

public class PanelGrafico extends JPanel {

    private List<Grafica> graficas = new ArrayList<>();

    public PanelGrafico(List<Grafica> figuras) {

        // PanelReporte.listaToken = listaToken;

        this.setBackground(Color.black);
        this.setBounds(20, 15, 500, 600);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.BLACK, 1)); // Establece un borde al panel

        graficas = figuras;
        

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // Casting a Graphics2D
        for (Grafica figura : graficas) {
            figura.dibujar(g2d);
            System.out.println("dibujando");
        }
    }

}
