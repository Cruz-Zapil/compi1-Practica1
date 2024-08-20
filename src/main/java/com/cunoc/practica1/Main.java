package com.cunoc.practica1;

import java.awt.Window;

import com.cunoc.practica1.frontEnd.VentanPrincipal;

public class Main {
    static VentanPrincipal hPrincipal;
    public static void main(String[] args) {
        // Cadena de entrada a analizar
        
      VentanPrincipal nueva =  new VentanPrincipal();
      hPrincipal=nueva;
        
    }

    public static void reiniciarPrograma() {
       
        // Cerrar la ventana actual
        hPrincipal.dispose();
        // Crear una nueva instancia de la ventana
        VentanPrincipal nueva = new VentanPrincipal();
        hPrincipal = nueva;
    }
}
