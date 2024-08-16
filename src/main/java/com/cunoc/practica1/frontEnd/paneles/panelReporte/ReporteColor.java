package com.cunoc.practica1.frontEnd.paneles.panelReporte;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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

public class ReporteColor extends JPanel {


    public static DefaultTableModel model;

    private HashMap<String, Integer> reporte;
    
    public ReporteColor(HashMap<String, Integer> reporte) {

        this.reporte = reporte;

        this.setBackground(new Color(245, 245, 220));
        this.setBounds(0, 0, 600, 660);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.BLACK, 1)); // Establece un borde al panel

        agregrarTabla();
        

    }

    public void agregrarTabla() {
        model = new DefaultTableModel();
        model.addColumn("Simbolo");
        model.addColumn("Tipo");
     //  model.addColumn("Valor");
        model.addColumn("Linea");
        model.addColumn("Columna");

        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 13)); // Cambia la fuente
        table.setRowHeight(30); // Cambia la altura de las filas
        table.setIntercellSpacing(new Dimension(0, 0)); // Elimina el espaciado entre celdas
        table.setLocation(0, 0);

        // Personaliza el encabezado de la tabla
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia la fuente del encabezado
        header.setBackground(new Color(255, 182, 193)); // Cambia el color de fondo del encabezado
        header.setForeground(Color.black); // Cambia el color del texto del encabezado

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Elimina el borde del JScrollPane
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Establece el tamaño preferido
        scrollPane.setBounds(25, 100, 550, 475);

        

        this.add(scrollPane);
    }




    
}
