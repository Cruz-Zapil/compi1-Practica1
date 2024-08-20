package com.cunoc.practica1.frontEnd.paneles.panelGrafico;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.cunoc.practica1.backEnd.objetos.Grafica;
import com.cunoc.practica1.backEnd.objetos.animation.Animacion;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.Message;

public class Animaciones {

    // Lista común para los errores

    private double t = 0;
    private int indiceAnimacionActual = 0; // Controla qué figura está siendo animada

    PanelGrafico panelGrafico;
    List<Grafica> listaGraficaEnviado;

    public void realizarAnimaciones(PanelGrafico panelGrafico, List<Grafica> listaGraficaEnviado) {
        this.panelGrafico = panelGrafico;
        this.listaGraficaEnviado = listaGraficaEnviado;
        ordenar();
        animacionSecuencial();

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

    }

    public void animacionSecuencial() {
        t = 0;

        if (indiceAnimacionActual < listaGraficaEnviado.size()) {
            Grafica figuraActual = listaGraficaEnviado.get(indiceAnimacionActual);

            if (figuraActual.getAnimacion() != null) {
                // Obtener posición de destino
                int destinoX = (int) figuraActual.getAnimacion().getDestinoX();
                int destinoY = (int) figuraActual.getAnimacion().getDestinoY();

                // Calcular la distancia total (solo para línea recta)
                double distanciaTotal = Math.hypot(destinoX - figuraActual.getPosx(),
                        destinoY - figuraActual.getPosy());

                Timer timer = new Timer(16, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        t += 0.005; // Incrementar el tiempo para la animación

                        // Obtener la posición actual de la figura
                        int posXActual = (int) figuraActual.getPosx();
                        int posYActual = (int) figuraActual.getPosy();

                        // valores cercanos al destino
                        int enX = Math.abs(posYActual - destinoY);
                        int enY = Math.abs(posXActual - destinoX);

                        if ((posXActual == destinoX && posYActual == destinoY) || (enX < 100 && enY < 100
                                && figuraActual.getAnimacion().getTipoAnimacion().equals("CURVA"))) {
                            ((Timer) e.getSource()).stop(); // Detener el timer de la animación actual
                            indiceAnimacionActual++; // Pasar a la siguiente figura
                            animacionSecuencial(); // Llamar nuevamente para animar la siguiente figura

                        }

                        // Verificar el tipo de animación
                        if (figuraActual.getAnimacion().getTipoAnimacion().equals("CURVA")) {
                            // Animación en curva senoidal
                            int x = (int) (posXActual + 10 * Math.sin(t * 2 * Math.PI)); // Movimiento horizontal
                                                                                         // con onda senoidal
                            int y = (int) (posYActual + 10 * Math.cos(t * 2 * Math.PI)); // Movimiento vertical con
                                                                                         // onda senoidal
                            figuraActual.mover(x, y);
                        } else if (figuraActual.getAnimacion().getTipoAnimacion().equals("LINEA")) {
                            // Animación en línea recta
                            double deltaX = destinoX - posXActual;
                            double deltaY = destinoY - posYActual;

                            // Normalizar las diferencias para mantener la misma velocidad en todas las
                            // direcciones
                            double distanciaRecorrida = t * distanciaTotal; // Progresión en función de `t`
                            double factorProgreso = distanciaRecorrida / distanciaTotal; // Factor de progreso
                                                                                         // normalizado

                            // Calcular la nueva posición
                            int nuevoX = (int) (posXActual + factorProgreso * deltaX);
                            int nuevoY = (int) (posYActual + factorProgreso * deltaY);

                            figuraActual.mover(nuevoX, nuevoY);
                        }

                        panelGrafico.repaint(); // Redibujar el panel

                        // Verificar si la figura ha llegado al destino
                        if (haLlegadoAlDestino(figuraActual, destinoX, destinoY)) {
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
        } else {
            Message.mostrarMensajeInfo("No hay ninguna animación", "Error");
        }
    }

    // Método para verificar si la figura ha llegado al destino
    private boolean haLlegadoAlDestino(Grafica figura, int destinoX, int destinoY) {
        int posXActual = (int) figura.getPosx();
        int posYActual = (int) figura.getPosy();
        // Verificar si la figura está lo suficientemente cerca del destino
        return Math.abs(posXActual - destinoX) < 5 && Math.abs(posYActual - destinoY) < 5;
    }

}