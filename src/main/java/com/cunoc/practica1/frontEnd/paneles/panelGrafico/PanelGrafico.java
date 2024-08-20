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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.LogicaArchivos;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

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


public void guardarPanel() {
    System.out.println("Se va a exportar el panel");

    String ruta = new LogicaArchivos().obtenerRutaCarpeta();

    int ancho = this.getWidth();
    int alto = this.getHeight();

    // Crear un BufferedImage con el tamaño del panel
    BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

    // Obtener el Graphics2D del buffer de la imagen
    Graphics2D g2d = imagen.createGraphics();

    // Renderizar el contenido del panel en el Graphics2D
    this.paint(g2d);

    // Liberar recursos del Graphics2D
    g2d.dispose();

    // Guardar la imagen PNG
    try {
        File archivoImagen = new File(ruta + "/imagen_panel.png");
        ImageIO.write(imagen, "png", archivoImagen);
        System.out.println("Imagen PNG guardada en: " + archivoImagen.getAbsolutePath());

        // Abrir la imagen PNG en el visor predeterminado del sistema
        Desktop.getDesktop().open(archivoImagen);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Guardar la imagen en un archivo PDF
    try {
        Document document = new Document(new com.itextpdf.text.Rectangle(ancho, alto));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "/imagen_panel.pdf"));
        document.open();

        // Convertir BufferedImage a Image para PDF
        com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance(writer, imagen, 1.0f);
        document.add(pdfImage);

        document.close();
        System.out.println("PDF guardado en: " + ruta + "/imagen_panel.pdf");

        // Abrir el archivo PDF en el visor predeterminado del sistema
        File archivoPDF = new File(ruta + "/imagen_panel.pdf");
        Desktop.getDesktop().open(archivoPDF);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
