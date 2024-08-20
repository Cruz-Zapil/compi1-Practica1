package com.cunoc.practica1.frontEnd.paneles.panelReporte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cunoc.practica1.backEnd.report.Errores;
import com.cunoc.practica1.backEnd.report.Operadores;

public class PanelReporte extends JPanel implements ActionListener {

    // Lista de errores estática
    private static List<Errores> listaErrores = new ArrayList<>();

    // Método estático para agregar errores
    public static void agregarError(Errores error) {
        listaErrores.add(error);
    }

    // Método estático para obtener la lista de errores
    public static List<Errores> getListaErrores() {
        return listaErrores;
    }

    /// reportes enviados
    private HashMap<String, Integer> reporteColor;
    private HashMap<String, Integer> reporteFigura;
    private HashMap<String, Integer> reporteAnimacion;
    private List<Operadores> operador;

    private JTable tablaReporte = null;
    private JScrollPane scrollPane = null;

    /// menu

    private JMenuBar menuBar;
    private JMenu archivoMenu;

    // private static ListaEnlazada listaToken;

    public PanelReporte(HashMap<String, Integer> color, HashMap<String, Integer> figura,
            HashMap<String, Integer> animacion,
            List<Operadores> operador) {
        this.reporteColor = color;
        this.reporteFigura = figura;
        this.reporteAnimacion = animacion;
        this.operador = operador;

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

        if (scrollPane != null) {
            this.remove(scrollPane);
        }

        //// panel de lot text area
        DefaultTableModel model = new DefaultTableModel();

        if (numero == 1) {

            model.addColumn("Operador");
            model.addColumn("Linea");
            model.addColumn("Columna");
            model.addColumn("Ocurrencia");

            // añadir datos:

            if (operador != null) {

                for (Operadores operador : operador) {
                    model.addRow(new Object[] { operador.getOperador(), operador.getLinea(), operador.getColumna(),
                            operador.getOcurrencia() });
                }
            }

        } else if (numero == 2) {
            model.addColumn("Color");
            model.addColumn("Cantidad de uso");

            // añadir datos:
            // Recorre el HashMap reporteColor
            if (reporteColor != null) {

                for (Map.Entry<String, Integer> entry : reporteColor.entrySet()) {
                    String color = entry.getKey(); // Obtiene la clave (en este caso, el código del color)
                    Integer cantidad = entry.getValue(); // Obtiene el valor (en este caso, el número asociado al color)

                    model.addRow(new Object[] { color, cantidad });
                }
            }

        } else if (numero == 3) {
            model.addColumn("Objeto");
            model.addColumn("Cantidad de uso");
            // Añadir datos a la columa:

            if (reporteFigura != null) {
                for (Map.Entry<String, Integer> entry : reporteFigura.entrySet()) {
                    String color = entry.getKey(); // Obtiene la clave (en este caso, el código del color)
                    Integer cantidad = entry.getValue(); // Obtiene el valor (en este caso, el número asociado al color)

                    model.addRow(new Object[] { color, cantidad });
                }
            }

        } else if (numero == 4) {
            model.addColumn("Animacion");
            model.addColumn("Cantidad de uso");
            // Añadir datos a las columnas:

            if (reporteAnimacion != null) {

                for (Map.Entry<String, Integer> entry : reporteAnimacion.entrySet()) {
                    String color = entry.getKey(); // Obtiene la clave (en este caso, el código del color)
                    Integer cantidad = entry.getValue(); // Obtiene el valor (en este caso, el número asociado al color)

                    model.addRow(new Object[] { color, cantidad });
                }
            }
        } else if (numero == 5) {
            model.addColumn("Lexema");
            model.addColumn("Línea");
            model.addColumn("Columna");
            model.addColumn("Tipo");
            model.addColumn("Descripcion");
            // Añadir datos a las nuevas columnas (si es necesario)
            if (listaErrores != null) {
                for (Errores error : listaErrores) {
                    model.addRow(
                            new Object[] { error.getLexema(), error.getLinea(), error.getColumna(), error.getTipo(),
                                    error.getDescripcion() });
                }

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Operadores Matematicos":
                agregrarTabla(1);

                break;
            case "Colores usados":
                agregrarTabla(2);
                break;
            case "Objetos usados":
                agregrarTabla(3);
                break;
            case "Animacines usados":
                agregrarTabla(4);
                break;
            case "Reporte Errores":
                agregrarTabla(5);
                break;
            default:
                break;
        }

    }

}
