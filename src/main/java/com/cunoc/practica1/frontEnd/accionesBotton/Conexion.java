package com.cunoc.practica1.frontEnd.accionesBotton;

import com.cunoc.practica1.backEnd.AFND.Lexer;
import com.cunoc.practica1.backEnd.AFND.parser;
import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.backEnd.objetos.animation.Animacion;

import com.cunoc.practica1.backEnd.report.Operadores;
import com.cunoc.practica1.frontEnd.VentanPrincipal;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.Message;
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
    private List<Operadores> reporteOperadores;

    // lista de errores
    // Lista común para los errores

    private double t = 0;
    private int indiceAnimacionActual = 0; // Controla qué figura está siendo animada

    public void ejecutar(String codigo) {

        if (codigo != null && !codigo.equals("")) {

            try {

                Reader extraerTexto = new StringReader(codigo);

                Lexer lexer = new Lexer(extraerTexto);

                parser cupParser = new parser(lexer);
                cupParser.parse(); // Ejecutar el parser

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
                    // Cambia la comparación para ordenar de mayor a menor
                    if (animacionActual.getOrden() < animacionAuxi.getOrden()) {
                        listaGraficaEnviado.set(j + 1, listaGraficaEnviado.get(j));
                        j--;
                    } else {
                        break;
                    }
                }

            }
            listaGraficaEnviado.set(j + 1, auxi);
        }

        Message.mostrarConfirmacion("W", "dkha");
        for (Grafica h : listaGraficaEnviado) {

            System.out.println(h.getNombre());
            Message.mostrarConfirmacion(h.getNombre(), "grafica");
        }
    }

    // Método para animar las figuras en secuencia
    public void animacionSecuencial() {
        t=0;

        if (indiceAnimacionActual < listaGraficaEnviado.size()) {
            Grafica figuraActual = listaGraficaEnviado.get(indiceAnimacionActual);
              /// posx y posy
            
                int tmpDX = (int)figuraActual.getAnimacion().getDestinoX();
                int tmpDY =  (int)figuraActual.getAnimacion().getDestinoY();


            if (figuraActual.getAnimacion() != null) {
                Timer timer = new Timer(16, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        t += 0.005; // Incrementar el tiempo para la animación
                        
                        /// movimiento en variable 
                        int tmposX = (int) figuraActual.getPosx();
                        int tmposY = (int)figuraActual.getPosy();

                        // Realizar la animación de la figura actual
                        if (figuraActual.getAnimacion().getTipoAnimacion().equals("CURVA")) {

                            // movimiento a
                            if (tmposX > tmpDX && tmposY > tmpDY) {

                                  // Movdimiento a lo largo de una curva senoidal
                            int x = (int) (tmpDX - 10 * Math.sin(t));
                            int y = (int) (tmpDX - 10 * Math.cos(t));
                            figuraActual.mover(x, y);
                                // movimiento b
                            }else if ( tmposX == tmpDX && tmposY > tmpDY) {
                                 
                                int y = (int) (tmpDX - 10 * Math.cos(t));
                                figuraActual.mover(tmposX, y);
                        
                                // movimiento c
                        }else if ( tmposX < tmpDX && tmposY > tmpDY) {
                            int x = (int) (tmpDX + 10 * Math.sin(t));
                            int y = (int) (tmpDX - 10 * Math.cos(t));
                            figuraActual.mover(x, y);

                            /// movimiento d
                        }else if ( tmposX > tmpDX && tmposY == tmpDY) {
                            int x = (int) (tmpDX - 10 * Math.sin(t));
                            figuraActual.mover(x, tmposY);

                            // movimeinto e
                        }else if ( tmposX < tmpDX && tmposY == tmpDY) {
                            int x = (int) (tmpDX + 10 * Math.sin(t));
                            figuraActual.mover(x, tmposY);

                            /// movimiento f
                        }else if ( tmposX > tmpDX && tmposY < tmpDY) {
                            int x = (int) (tmpDX - 10 * Math.sin(t));
                            int y = (int) (tmpDX + 10 * Math.cos(t));
                            figuraActual.mover(x, y);

                            /// movimiento g

                        }else if ( tmposX == tmpDX && tmposY < tmpDY) {
                            int y = (int) (tmpDX + 10 * Math.cos(t));
                            figuraActual.mover(tmposX,  y);

                            /// movimiento h
                        }else if ( tmposX < tmpDX && tmposY < tmpDY) {
                            int x = (int) (tmpDX + 10 * Math.sin(t));
                            int y = (int) (tmpDX + 10 * Math.cos(t));
                            figuraActual.mover(x, y);
                        }else if (tmposX == tmpDX && tmposY == tmpDY) {
                            Message.mostrarMensajeInfo("La figura: "+ figuraActual.getNombre() +" llego a su destino", "Info");

                            ((Timer) e.getSource()).stop(); // Detener el timer de la animación actual
                            indiceAnimacionActual++; // Pasar a la siguiente figura
                            animacionSecuencial(); // Llamar nuevamente para animar la siguiente figura
                        }
                            
                        } else if (figuraActual.getAnimacion().getTipoAnimacion().equals("LINEA")) {

                            // Movimiento en línea recta hacia un destino
                            int xl = (int )(figuraActual.getPosx()+figuraActual.getAnimacion().getDestinoX() * t);
                            int yl =(int )(figuraActual.getPosy()+figuraActual.getAnimacion().getDestinoY() * t);
                         

                            if (tmposX > tmpDX && tmposY > tmpDY) {

                                // Movdimiento a lo largo de una curva senoidal
                          int x = (int) (tmpDX - 10 * t);
                          int y = (int) (tmpDX - 10 * t);
                          figuraActual.mover(x, y);
                              // movimiento b
                          }else if ( tmposX == tmpDX && tmposY > tmpDY) {
                               
                              int y = (int) (tmpDX - 10 * t);
                              figuraActual.mover(tmposX, y);
                      
                              // movimiento c
                      }else if ( tmposX < tmpDX && tmposY > tmpDY) {
                          int x = (int) (tmpDX + 10 * t);
                          int y = (int) (tmpDX - 10 * t);
                          figuraActual.mover(x, y);

                          /// movimiento d
                      }else if ( tmposX > tmpDX && tmposY == tmpDY) {
                          int x = (int) (tmpDX - 10 * t);
                          figuraActual.mover(x, tmposY);

                          // movimeinto e
                      }else if ( tmposX < tmpDX && tmposY == tmpDY) {
                          int x = (int) (tmpDX + 10 * t);
                          figuraActual.mover(x, tmposY);

                          /// movimiento f
                      }else if ( tmposX > tmpDX && tmposY < tmpDY) {
                          int x = (int) (tmpDX - 10 * t);
                          int y = (int) (tmpDX + 10 * t);
                          figuraActual.mover(x, y);

                          /// movimiento g

                      }else if ( tmposX == tmpDX && tmposY < tmpDY) {
                          int y = (int) (tmpDX + 10 * t);
                          figuraActual.mover(tmposX,  y);

                          /// movimiento h
                      }else if ( tmposX < tmpDX && tmposY < tmpDY) {
                          int x = (int) (tmpDX + 10 * t);
                          int y = (int) (tmpDX + 10 * t);
                          figuraActual.mover(x, y);
                      }else if (tmposX == tmpDX && tmposY == tmpDY) {
                          Message.mostrarMensajeInfo("La figura: "+ figuraActual.getNombre() +" llego a su destino", "Info");

                          ((Timer) e.getSource()).stop(); // Detener el timer de la animación actual
                          indiceAnimacionActual++; // Pasar a la siguiente figura
                          animacionSecuencial(); // Llamar nuevamente para animar la siguiente figura
                      }


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
        }else {
            Message.mostrarMensajeInfo("No hay ninguna animacion", "Error");
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