package com.cunoc.practica1.frontEnd.accionesBotton;

import com.cunoc.practica1.backEnd.AFND.Lexer;
import com.cunoc.practica1.backEnd.AFND.parser;

import java.io.Reader;
import java.io.StringReader;

public class Conexion {

    public void ejecutar(String codigo) {

        if (codigo != null && !codigo.equals("")) {

            try {

                Reader extraerTexto = new StringReader(codigo);

                Lexer lexer = new Lexer(extraerTexto);

                parser parser = new parser(lexer);
                parser.parse(); // Ejecutar el parser

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}