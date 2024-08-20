package com.cunoc.practica1.backEnd.AFND;

import java_cup.runtime.Symbol;
import com.cunoc.practica1.backEnd.report.Errores;
import com.cunoc.practica1.frontEnd.paneles.panelReporte.PanelReporte;

%%
%public
%class Lexer
%cup
%unicode
%ignorecase

digit=[0-9]
letter=[a-zA-Z]

AZUL="azul"
ROJO="rojo"
AMARILLO="amarillo"
VERDE="verde"
NARANJA="NARANJA"
BLANCO="blanco"
CELESTE="celeste"
ROSA="ROSA"
GRIS="gris"
CURVA="curva"

%init{ 
    yyline = 1; 
    yychar = 0; 
    
%init} 
 

%{

    StringBuffer string = new StringBuffer();
    int longitudToken=0;

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

%%

{digit}+("."{digit}+)? {   longitudToken = yytext().length();
    yychar+=longitudToken; return new Symbol(sym.NUMERO, yyline, (int)yychar, Double.valueOf(yytext())); }

"graficar" {yychar+=8; return new Symbol(sym.GRAFICAR, yyline, (int)yychar, yytext()); }
"circulo" { yychar+=7;return new Symbol(sym.CIRCULO, yyline, (int)yychar, yytext()); }
"cuadrado" {yychar+=8;return new Symbol(sym.CUADRADO,yyline, (int)yychar, yytext()); }
"rectangulo" {yychar+=10;return new Symbol(sym.RECTANGULO,yyline, (int)yychar, yytext()); }
"linea" {yychar+=5; return new Symbol(sym.LINEA,yyline, (int)yychar, yytext()); }
"poligono" {yychar+=8;return new Symbol(sym.POLIGONO, yyline, (int)yychar,yytext()); }

"animar" { yychar+=6; return new Symbol(sym.ANIMAR,yyline, (int)yychar, yytext()); }
"objeto anterior" { yychar+=15; return new Symbol(sym.OBJETO_ANTERIOR,yyline, (int)yychar, yytext()); }
"," {yychar+=1; return new Symbol(sym.COMA,yyline, (int)yychar, yytext()); }
"(" {yychar+=1; return new Symbol(sym.LPAREN,yyline, (int)yychar,yytext()); }
")" {yychar+=1; return new Symbol(sym.RPAREN,yyline, (int)yychar, yytext()); }
"+" {yychar+=1; return new Symbol(sym.PLUS, yyline, (int)yychar,yytext()); }
"-" {yychar+=1; return new Symbol(sym.MINUS,yyline, (int)yychar, yytext()); }
"*" {yychar+=1; return new Symbol(sym.TIMES, yyline, (int)yychar,yytext()); }
"/" {yychar+=1; return new Symbol(sym.DIVIDE, yyline, (int)yychar,yytext()); }
[\n\r] {yychar=1; yyline++; }
{AZUL} {yychar+=4; return new Symbol(sym.AZUL,yyline, (int)yychar, yytext()); }
{ROJO} {yychar+= 4; return new Symbol(sym.ROJO,yyline, (int)yychar, yytext()); }
{VERDE} {yychar+=5 ; return new Symbol(sym.VERDE,yyline, (int)yychar, yytext()); }
{ROSA} {yychar+= 4; return new Symbol(sym.ROSA,yyline, (int)yychar, yytext()); }
{BLANCO} { yychar+=1;return new Symbol(sym.BLANCO,yyline, (int)yychar, yytext()); }
{CELESTE} {yychar+=7;return new Symbol(sym.CELESTE, yyline, (int)yychar,yytext());}
{NARANJA} {yychar+=7 ;return new Symbol(sym.NARANJA,yyline, (int)yychar, yytext());}
{GRIS} {yychar+=4 ; return new Symbol(sym.GRIS,yyline, (int)yychar, yytext());}
{AMARILLO} {yychar+=8 ; return new Symbol(sym.AMARILLO, yyline, (int)yychar, yytext());}
{CURVA} {yychar+= 5;return new Symbol(sym.CURVA, yyline, (int)yychar, yytext());}
" " {yychar+=1; /* ignore */}


[a-zA-Z_][a-zA-Z0-9_]* {  
    longitudToken = yytext().length();
    yychar+=longitudToken;
    return new Symbol(sym.NOMBRE, yyline, (int)yychar , yytext()); 
}





// Código en tu lexer
[^] { 
    yychar+=1;
    // Agregar el error léxico a la lista

    PanelReporte.agregarError(new Errores("Léxico", yytext() ,"Caracter inválido: " + yytext(), yyline, (int)yychar));
}