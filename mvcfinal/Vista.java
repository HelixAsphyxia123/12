/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import static mvcfinal.InterfazVista.ABRIR;
import static mvcfinal.InterfazVista.DECRYPT;
import static mvcfinal.InterfazVista.ENCRYPT;
import static mvcfinal.InterfazVista.GUARDAR;

public class Vista extends JFrame {

    private final JTextArea text; // displays file
    private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;
    private final JButton openJButton;
    private final JTextField fileName; // file name

    public Vista() {
        super(" Cifrado por VLCA ~ Docente: Levy Rojas ");
        JPanel fileJPanel;
        JLabel lblFile;
        JPanel buttonJPanel;
        BorderLayout layout;

        layout = new BorderLayout(20, 10);
        setLayout(layout);
        fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        lblFile = new JLabel(" Archivo de texto / cifrado :");
        lblFile.setToolTipText(" Archivo a abrir ");
        fileJPanel.add(lblFile);
        fileName = new JTextField(20);
        fileJPanel.add(fileName);
        add(fileJPanel, BorderLayout.CENTER);
        text = new JTextArea(10, 15);
        add(new JScrollPane(text), BorderLayout.NORTH);
        
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(4, 1));
        openJButton = new JButton(ABRIR);
        buttonJPanel.add(openJButton);
        encryptJButton = new JButton(ENCRYPT);
        buttonJPanel.add(encryptJButton);
        decryptJButton = new JButton(DECRYPT);
        buttonJPanel.add(decryptJButton);
        saveJButton = new JButton(GUARDAR);
        buttonJPanel.add(saveJButton);
        add(buttonJPanel, BorderLayout.EAST);
        this.encryptJButton.setBackground(Color.GREEN);
        this.decryptJButton.setBackground(Color.blue);
        this.saveJButton.setBackground(Color.LIGHT_GRAY);

    }

    public String getFileName() {
        return fileName.getText();
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String s) {
        text.setText(s);
    }

    public void setControlador(Controlador c) {
        openJButton.addActionListener(c);
        saveJButton.addActionListener(c);
        encryptJButton.addActionListener(c);
        decryptJButton.addActionListener(c);
    }
}
