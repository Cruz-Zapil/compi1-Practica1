package com.cunoc.practica1.frontEnd.paneles.panelEscritura;

import javax.swing.*;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Panel1Escritura extends JPanel {

    /// panel que recibe texto o se escribe texto 
    private static JTextPane textAreaImput;

    public Panel1Escritura() {

        this.setLayout(new BorderLayout());

        Font fuentePersonalizada = new Font("Arial", Font.PLAIN, 16); 
        // Crear dos JTextAreas
        textAreaImput = new JTextPane();
        textAreaImput.setFont(fuentePersonalizada);

        // Crear un JScrollPane
        JScrollPane scrollPane = new JScrollPane();

        // Agregar los JTextAreas al JScrollPane
        scrollPane.setViewportView(textAreaImput);
        scrollPane.setRowHeaderView(new LineNumberTextPane(textAreaImput));
        addScrollSync(scrollPane, textAreaImput);

        // Agregar el JScrollPane al panel
        this.add(scrollPane);
        this.setBounds(30, 15, 700, 600);
        this.setVisible(true);

    }

    private static void addScrollSync(JScrollPane sourceScrollPane, JTextPane targetTextArea1) {

        sourceScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Rectangle visibleRect = targetTextArea1.getVisibleRect();
                Rectangle desiredRect = new Rectangle(targetTextArea1.getSize());
                
                if (!visibleRect.equals(desiredRect)) {
                    targetTextArea1.scrollRectToVisible(desiredRect);
                }
            }
        });
        
    }

    public static void setText(String text) {
        textAreaImput.setText(text);
    }

    public static String getText() {
      //  System.out.println("texto de contenido: " + textAreaImput.getText());
        return textAreaImput.getText();
    }


}

class LineNumberTextPane extends JTextPane {

    private JTextPane textPane;

    public LineNumberTextPane(JTextPane textPane) {
        this.textPane = textPane;
        
        Font fuentePersonalizada = new Font("Arial", Font.PLAIN, 16); 
        this.setFont(fuentePersonalizada);
        setEditable(false);
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(40, Integer.MAX_VALUE));
        updateLineNumbers();

        textPane.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Este método es relevante para cambios en atributos del estilo del texto
            }
        });
    }

    private void updateLineNumbers() {
        StyledDocument doc = textPane.getStyledDocument();
        int totalLines = doc.getDefaultRootElement().getElementCount();
        StringBuilder lineNumbers = new StringBuilder();
        for (int i = 1; i <= totalLines; i++) {
            lineNumbers.append(i).append('\n');
        }

        setText(lineNumbers.toString());
    }

}
