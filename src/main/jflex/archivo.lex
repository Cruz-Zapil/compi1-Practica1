package com.cunoc.practica1.backEnd.AFND;

import java_cup.runtime.Symbol;


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
MORADO="morado"
NEGRO="negro"
CELESTE="celeste"
LILA="lila"
GRIS="gris"
CURVA="curva"

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 
 

%{

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}



%%

{digit}+("."{digit}+)? { return new Symbol(sym.NUMERO,  Double.valueOf(yytext())); }

"graficar" { return new Symbol(sym.GRAFICAR, yyline, (int)yychar, yytext()); }
"circulo" { return new Symbol(sym.CIRCULO, yyline, (int)yychar, yytext()); }
"cuadrado" { return new Symbol(sym.CUADRADO,yyline, (int)yychar, yytext()); }
"rectangulo" { return new Symbol(sym.RECTANGULO,yyline, (int)yychar, yytext()); }
"linea" { return new Symbol(sym.LINEA,yyline, (int)yychar, yytext()); }
"poligono" {return new Symbol(sym.POLIGONO, yyline, (int)yychar,yytext()); }

"animar" {  return new Symbol(sym.ANIMAR,yyline, (int)yychar, yytext()); }
"objeto anterior" { return new Symbol(sym.OBJETO_ANTERIOR,yyline, (int)yychar, yytext()); }
"," { return new Symbol(sym.COMA,yyline, (int)yychar, yytext()); }
"(" { return new Symbol(sym.LPAREN,yyline, (int)yychar,yytext()); }
")" { return new Symbol(sym.RPAREN,yyline, (int)yychar, yytext()); }
"+" { return new Symbol(sym.PLUS, yyline, (int)yychar,yytext()); }
"-" { return new Symbol(sym.MINUS,yyline, (int)yychar, yytext()); }
"*" { return new Symbol(sym.TIMES, yyline, (int)yychar,yytext()); }
"/" { return new Symbol(sym.DIVIDE, yyline, (int)yychar,yytext()); }
[\n\r]+ {yychar++; return new Symbol(sym.NEWLINE,yyline, (int)yychar, yytext()); }
{AZUL} {  return new Symbol(sym.AZUL,yyline, (int)yychar, yytext()); }
{ROJO} { return new Symbol(sym.ROJO,yyline, (int)yychar, yytext()); }
{VERDE} { return new Symbol(sym.VERDE,yyline, (int)yychar, yytext()); }
{MORADO} { return new Symbol(sym.MORADO,yyline, (int)yychar, yytext()); }
{NEGRO} { return new Symbol(sym.NEGRO,yyline, (int)yychar, yytext()); }
{CELESTE} {return new Symbol(sym.CELESTE, yyline, (int)yychar,yytext());}
{LILA} {return new Symbol(sym.LILA,yyline, (int)yychar, yytext());}
{GRIS} { return new Symbol(sym.GRIS,yyline, (int)yychar, yytext());}
{AMARILLO} { return new Symbol(sym.AMARILLO, yyline, (int)yychar, yytext());}
{CURVA} {return new Symbol(sym.CURVA, yyline, (int)yychar, yytext());}
" "+ {/* ignore */}

[a-zA-Z_][a-zA-Z0-9_]* {  return new Symbol(sym.NOMBRE,yyline, (int)yychar, yytext()); }


[^] { System.out.println("Este es un error lexico: "+yytext()+", en la linea: " + yyline + ", en la columna: "+yychar); }

