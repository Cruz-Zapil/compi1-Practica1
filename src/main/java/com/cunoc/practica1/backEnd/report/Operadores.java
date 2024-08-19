package com.cunoc.practica1.backEnd.report;

public class Operadores {
    private String operador;
    private int linea;
    private int columna;
    private String ocurrencia;


    public Operadores(String operador, int linea, int columna, String ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ocurrencia = ocurrencia;
    }


    public String getOperador() {
        return operador;
    }


    public int getLinea() {
        return linea;
    }


    public int getColumna() {
        return columna;
    }


    public String getOcurrencia() {
        return ocurrencia;
    }
    

    
}
