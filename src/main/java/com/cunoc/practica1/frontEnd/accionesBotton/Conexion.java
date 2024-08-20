package com.cunoc.practica1.frontEnd.accionesBotton;

import com.cunoc.practica1.backEnd.AFND.Lexer;
import com.cunoc.practica1.backEnd.AFND.parser;
import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

import com.cunoc.practica1.backEnd.report.Operadores;
import com.cunoc.practica1.frontEnd.VentanPrincipal;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.Message;
import com.cunoc.practica1.frontEnd.paneles.panelGrafico.Animaciones;
import com.cunoc.practica1.frontEnd.paneles.panelGrafico.PanelGrafico;
import com.cunoc.practica1.frontEnd.paneles.panelReporte.PanelReporte;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class Conexion {

    private PanelGrafico panelGrafico;
    private List<Grafica> listaGraficaEnviado = new ArrayList<>();
    /// reportes enviados
    private HashMap<String, Integer> reporteColor;
    private HashMap<String, Integer> reporteFigura;
    private HashMap<String, Integer> reporteAnimacion;
    private List<Operadores> reporteOperadores;

    // lista de errores
  
    public void ejecutar(String codigo) {

        if (codigo != null && !codigo.equals("")) {

            try {

                Reader extraerTexto = new StringReader(codigo);

                Lexer lexer = new Lexer(extraerTexto);

                parser cupParser = new parser(lexer);
                cupParser.parse(); // Ejecutar el parser
                cupParser.terminarAnalisis(); // Finalizar el análisis
                listaGraficaEnviado = cupParser.getListaGrafica();

                reporteColor = cupParser.getReporteColor();
                reporteFigura = cupParser.getReporteFigura();
                reporteAnimacion = cupParser.gerReporteAnimacion();
                reporteOperadores = cupParser.getReporteOperacion();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" Error al conectar con lexer, prube reiniciando");
            }

        } else {
            Message.mostrarMensajeError("No hay ningun texto ", "ERROR");
        }
    }

    public void reportes() {
        PanelReporte panelReporte = new PanelReporte(reporteColor, reporteFigura, reporteAnimacion, reporteOperadores);
        VentanPrincipal.addPanelDerecho(panelReporte);
    }

    public void graficar() {

        panelGrafico = new PanelGrafico(listaGraficaEnviado);
        VentanPrincipal.addPanelDerecho(panelGrafico);
    }

    /// exportar imgen
    public void exportar() {
        panelGrafico.guardarPanel();
    }


    /// conector de animaciones
    public void comenzarAnimar(){
        Animaciones animaciones = new Animaciones();
        animaciones.realizarAnimaciones(panelGrafico, listaGraficaEnviado);
    }

}