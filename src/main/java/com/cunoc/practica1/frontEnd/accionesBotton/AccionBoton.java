package com.cunoc.practica1.frontEnd.accionesBotton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.LogicaArchivos;
import com.cunoc.practica1.frontEnd.accionesBotton.utils.Message;
import com.cunoc.practica1.Main;
import com.cunoc.practica1.frontEnd.VentanPrincipal;
import com.cunoc.practica1.frontEnd.compnents.ConstructorBotton;
import com.cunoc.practica1.frontEnd.paneles.panelEscritura.Panel1;
import com.cunoc.practica1.frontEnd.paneles.panelEscritura.Panel1Escritura;



public class AccionBoton implements ActionListener {

    private Panel1 panel1 = new Panel1();
 
    
    
    private Conexion conexion = new Conexion();

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof ConstructorBotton) {

            ConstructorBotton botones = (ConstructorBotton) event.getSource();

            if (botones.getText().equals("Archivo")) {
                // messaje
                message();

            } else if (botones.getText().equals("Grafico")) {
                System.out.println("Grafico ");

                  conexion.graficar();
            
            } else if (botones.getText().equals("Compilar")) {
            
                conexion.ejecutar(Panel1Escritura.getText());
                    Message.mostrarMensajeInfo("Compilado", "Compilado");

            } else if (botones.getText().equals("Limpiar")) {

                /// limpiar
                Panel1Escritura.setText("");
            } else if (botones.getText().equals("Animar")) {
                /// ayuda
                conexion.comenzarAnimar();

            } else if (botones.getText().equals("Exportar")) {
                conexion.exportar();

            } else if (botones.getText().equals("Reportes")) {
                System.out.println(" mostra tabla ");
                conexion.reportes();

            }else if (botones.getText().equals("Reiniciar")) {
                System.out.println(" reiniciar ");
                Main.reiniciarPrograma();
                
            }
            
        }
    }

    public void message() {
        String[] options = { "Abrir Archivo", "Nuevo", "Cancelar" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Attencion: ",
                "Seleccione una opción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Acción para "Abrir Archivo"
            VentanPrincipal.addPanelIzquiedo(panel1);
            Panel1Escritura.setText(new LogicaArchivos().fileChoser());
        } else if (choice == 1) {
            // Acción para "Nuevo"
            VentanPrincipal.addPanelIzquiedo(panel1);
        }
    }

}
