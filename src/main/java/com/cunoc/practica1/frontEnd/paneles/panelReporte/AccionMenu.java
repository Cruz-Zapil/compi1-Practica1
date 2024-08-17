package com.cunoc.practica1.frontEnd.paneles.panelReporte;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.cunoc.practica1.frontEnd.accionesBotton.utils.Message;


public class AccionMenu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof JMenuItem) {

            JMenuItem botonMenuReporte = (JMenuItem) event.getSource();
            
            
            if (botonMenuReporte.getText().equals("Operadores Matematicos")) {
                
            // PanelReporte.agregarDatosGlobal();
           // PanelReporte.mostrarOperadores();
            } else if (botonMenuReporte.getText().equals("Colores usados")){
              //  PanelReporte.mostrarColores();
            }else if (botonMenuReporte.getText().equals("Objetos usados")){
              // PanelReporte.mostarObjetos();
            }else if (botonMenuReporte.getText().equals("Animaciones usados")){
             //   PanelReporte.mostrarAnimacion();
            }else if (botonMenuReporte.getText().equals("Reporte Errores")){{
             //   PanelReporte.mostatErrores();
                
            }}

        }else {
            Message.mostrarMensajeInfo(" hoalñ"," else ");
        }
    }

}
