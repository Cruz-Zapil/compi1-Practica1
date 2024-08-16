package com.cunoc.practica1;

import java.io.FileReader;


import com.cunoc.practica1.backEnd.AFND.Lexer;
import com.cunoc.practica1.backEnd.AFND.parser;

public class Main {
    public static void main(String[] args) {
        // Cadena de entrada a analizar
        
        try {
            Lexer lexer = new Lexer(new FileReader("src/main/java/com/cunoc/practica1/entrada.txt"));  

            parser parser = new parser(lexer);
            parser.parse(); // Ejecutar el parser
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
