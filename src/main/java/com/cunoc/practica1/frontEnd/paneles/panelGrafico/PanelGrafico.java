package com.cunoc.practica1.frontEnd.paneles.panelGrafico;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.LogicaArchivos;

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

        System.out.println("numero de figuras: " + graficas.size());

        Graphics2D g2d = (Graphics2D) g; // Casting a Graphics2D
        for (Grafica figura : graficas) {
            figura.dibujar(g2d);
            System.out.println("dibujando");
        }
    }







    public void guardarPanel (){
        System.out.println(" se va exportar el panel ");

        String ruta  = new LogicaArchivos().obtenerRutaCarpeta();


        int ancho = this.getWidth();
        int alto = this.getHeight();

        /// crear un bufferedImage con el tamaño del panle
    
        BufferedImage imagen = new BufferedImage(alto, ancho,BufferedImage.TYPE_INT_ARGB );

        // obtener el graphics del buffer

        Graphics2D ged = imagen.createGraphics();

        // obtener el contenido del panel
        this.paint(ged);

        ged.dispose();

        // gurdar la imagen

        try{
            File archivoImagen = new File(ruta);
            ImageIO.write(imagen, "png", archivoImagen);
            System.out.println("Igen guardada en: " + ruta);
            Desktop.getDesktop().open(archivoImagen);
        }catch (IOException e) {
            e.printStackTrace();

        }
    }

}
