package com.cunoc.practica1.frontEnd.accionesBotton;

import com.cunoc.practica1.backEnd.AFND.Lexer;
import com.cunoc.practica1.backEnd.AFND.parser;
import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.backEnd.objetos.animation.Animacion;
import com.cunoc.practica1.backEnd.report.Errores;
import com.cunoc.practica1.backEnd.report.Operadores;
import com.cunoc.practica1.frontEnd.VentanPrincipal;
import com.cunoc.practica1.frontEnd.paneles.panelGrafico.PanelGrafico;
import com.cunoc.practica1.frontEnd.paneles.panelReporte.PanelReporte;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conexion {

    private PanelGrafico panelGrafico;
    private List<Grafica> listaGraficaEnviado = new ArrayList<>();
    /// reportes enviados
    private HashMap<String, Integer> reporteColor;
    private HashMap<String, Integer> reporteFigura;
    private HashMap<String, Integer> reporteAnimacion;
    private List<Operadores> reporteOperadores ;

    // lista de errores
    // Lista común para los errores



    private double t = 0;
    private int indiceAnimacionActual = 0; // Controla qué figura está siendo animada

    public void ejecutar(String codigo) {

        if (codigo != null && !codigo.equals("")) {

            try {

                Reader extraerTexto = new StringReader(codigo);

                Lexer lexer = new Lexer(extraerTexto);

                parser parser = new parser(lexer);
                parser.parse(); // Ejecutar el parser

                listaGraficaEnviado = parser.getListaGrafica();

                reporteColor = parser.getReporteColor();
                reporteFigura = parser.getReporteFigura();
                reporteAnimacion = parser.gerReporteAnimacion();
                reporteOperadores= parser.getReporteOperacion();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void reportes() {
        PanelReporte panelReporte = new PanelReporte(reporteColor, reporteFigura, reporteAnimacion,reporteOperadores);
        VentanPrincipal.addPanelDerecho(panelReporte);
    }

    public void graficar() {

        panelGrafico = new PanelGrafico(listaGraficaEnviado);
        VentanPrincipal.addPanelDerecho(panelGrafico);
    }

    public void ordenar() {

        int n = listaGraficaEnviado.size();
        for (int i = 1; i < n; i++) {
            Grafica auxi = listaGraficaEnviado.get(i);
            int j = i - 1;

            // mover los elementos
            while (j >= 0) {

                Animacion animacionActual = listaGraficaEnviado.get(j).getAnimacion();
                Animacion animacionAuxi = auxi.getAnimacion();

                if (animacionActual == null && animacionAuxi == null) {
                    break;
                } else if (animacionActual == null) {
                    break;
                } else if (animacionAuxi == null) {
                    listaGraficaEnviado.set(j + 1, listaGraficaEnviado.get(j));
                    j--;
                } else {
                    if (animacionActual.getOrden() > animacionAuxi.getOrden()) {
                        listaGraficaEnviado.set(j + 1, listaGraficaEnviado.get(j));
                        j--;
                    } else {
                        break;
                    }
                }

            }
            listaGraficaEnviado.set(j + 1, auxi);
        }
    }

    // Método para animar las figuras en secuencia
    public void animacionSecuencial() {
        ordenar(); // Ordenar la lista de gráficos según el orden de animación

        if (indiceAnimacionActual < listaGraficaEnviado.size()) {
            Grafica figuraActual = listaGraficaEnviado.get(indiceAnimacionActual);

            if (figuraActual.getAnimacion() != null) {
                Timer timer = new Timer(16, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        t += 0.01; // Incrementar el tiempo para la animación

                        // Realizar la animación de la figura actual
                        if (figuraActual.getAnimacion().getTipoAnimacion().equals("CURVA")) {
                            // Movimiento a lo largo de una curva senoidal
                            int x = (int) (figuraActual.getAnimacion().getDestinoX() + 100 * Math.sin(t));
                            int y = (int) (figuraActual.getAnimacion().getDestinoY() + 100 * Math.cos(t));
                            figuraActual.mover(x, y);
                        } else if (figuraActual.getAnimacion().getTipoAnimacion().equals("LINEA")) {
                            // Movimiento en línea recta hacia un destino
                            figuraActual.mover((int) figuraActual.getAnimacion().getDestinoX(),
                                    (int) figuraActual.getAnimacion().getDestinoY());
                        }

                        panelGrafico.repaint(); // Redibujar el panel

                        // Condición para determinar cuándo terminar la animación
                        if (haFinalizado(figuraActual)) {
                            ((Timer) e.getSource()).stop(); // Detener el timer de la animación actual
                            indiceAnimacionActual++; // Pasar a la siguiente figura
                            animacionSecuencial(); // Llamar nuevamente para animar la siguiente figura
                        }
                    }
                });
                timer.start(); // Iniciar la animación para la figura actual
            } else {
                // Si la figura actual no tiene animación, pasar a la siguiente
                indiceAnimacionActual++;
                animacionSecuencial();
            }
        }
    }

    // Método para verificar si una animación ha finalizado
    private boolean haFinalizado(Grafica figura) {
        // Puedes establecer aquí la lógica para determinar cuándo termina la animación
        // Por ejemplo, que la animación finalice cuando llegue a cierto punto o pase
        // cierto tiempo
        // Esto es solo un ejemplo básico
        return t >= 3.1416; // Finaliza una vez que completa un ciclo de sin/cos (2π ≈ 6.28)
    }

}