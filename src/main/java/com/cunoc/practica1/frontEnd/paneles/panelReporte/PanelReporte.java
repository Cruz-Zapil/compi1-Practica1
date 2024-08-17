package com.cunoc.practica1.frontEnd.paneles.panelReporte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelReporte extends JPanel implements ActionListener {

 
    private JTable tablaReporte = null;
    private JScrollPane scrollPane = null;

    /// menu

    private JMenuBar menuBar;
    private JMenu archivoMenu;

    // private static ListaEnlazada listaToken;

    public PanelReporte(/* ListaEnlazada listaToken */ ) {

        // PanelReporte.listaToken = listaToken;

        this.setBackground(new Color(245, 245, 220));
        this.setBounds(0, 0, 600, 660);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.BLACK, 1)); // Establece un borde al panel

        inicializarMenu();

    }

    private void inicializarMenu() {
        menuBar = new JMenuBar();
        // border
        menuBar.setBorder(new LineBorder(Color.BLACK, 1));
        // color
        menuBar.setBackground(new Color(173, 216, 230));

        archivoMenu = new JMenu("Lista de reportes");
        archivoMenu.setFont(new Font("Arial", Font.PLAIN, 14));

        menuBar.add(archivoMenu);
        menuBar.setBounds(25, 30, 250, 30);
        recorer();
        this.add(menuBar);
    }

    public void recorer() {
        /// crear objeto item
        JMenuItem item;

        /// agregar una lista a mi tabla
        item = new JMenuItem("Operadores Matematicos");
        item.addActionListener(this);
        archivoMenu.add(item);
        item = new JMenuItem("Colores usados");
        item.addActionListener(this);
        archivoMenu.add(item);
        item = new JMenuItem("Objetos usados");
        item.addActionListener(this);
        archivoMenu.add(item);
        item = new JMenuItem("Animacines usados");
        item.addActionListener(this);
        archivoMenu.add(item);
        item = new JMenuItem("Reporte Errores");
        item.addActionListener(this);
        archivoMenu.add(item);

        // Refresca la barra de menú
    }

    public void agregrarTabla(int numero) {

        if(scrollPane!= null){
            this.remove(scrollPane);
        }

        

   //// panel de lot text area
    DefaultTableModel  model = new DefaultTableModel();

        if (numero == 1) {

            model.addColumn("Operador");
            model.addColumn("Linea");
            model.addColumn("Columna");
            model.addColumn("Ocurrencia");

        } else if (numero == 2) {
            model.addColumn("Color");
            model.addColumn("Cantidad de uso");

        } else if (numero == 3) {
            model.addColumn("Objeto");
            model.addColumn("Cantidad de uso");
        } else if (numero == 4) {
            model.addColumn("Animacion");
            model.addColumn("Cantidad de uso");
        } else if (numero == 5) {
            model.addColumn("Lexema");
            model.addColumn("Línea");
            model.addColumn("Columna");
            model.addColumn("Tipo");
            model.addColumn("Descripcion");

        }

        tablaReporte = new JTable(model);
        tablaReporte.setFont(new Font("Arial", Font.PLAIN, 13)); // Cambia la fuente
        tablaReporte.setRowHeight(30); // Cambia la altura de las filas
        tablaReporte.setIntercellSpacing(new Dimension(0, 0)); // Elimina el espaciado entre celdas
        tablaReporte.setLocation(0, 0);

        // Personaliza el encabezado de la tabla
        JTableHeader header = tablaReporte.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia la fuente del encabezado
        header.setBackground(new Color(255, 182, 193)); // Cambia el color de fondo del encabezado
        header.setForeground(Color.black); // Cambia el color del texto del encabezado

        scrollPane = new JScrollPane(tablaReporte);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Elimina el borde del JScrollPane
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Establece el tamaño preferido
        scrollPane.setBounds(25, 100, 550, 475);



        this.add(scrollPane);

        this.repaint();
        this.revalidate();
    }

    public void mostrarOperadores() {
        System.out.println(" operador 1");
        agregrarTabla(1);

    }

    public void mostrarColores() {
        System.out.println(" operador 2");
        
        agregrarTabla(2);

    }

    public void mostarObjetos() {
        System.out.println(" operador 3");
        
        agregrarTabla(3);

    }

    public void mostrarAnimacion() {
        System.out.println(" operador 4");
        
        agregrarTabla(4);

    }

    public void mostatErrores() {
        System.out.println(" operador 5 ");
        
        agregrarTabla(5);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Operadores Matematicos":
                mostrarOperadores();
                break;
            case "Colores usados":
                mostrarColores();
                break;
            case "Objetos usados":
                mostarObjetos();
                break;
            case "Animacines usados":
                mostrarAnimacion();
                break;
            case "Reporte Errores":
                mostatErrores();
                break;
            default:
                break;
        }


    }

}
