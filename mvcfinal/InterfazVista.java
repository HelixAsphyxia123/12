/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcfinal;

/**
 *
 * @author valti
 */
public interface InterfazVista {

    void setControlador(Controlador c);

    public String getFileName();

    public String getText();

    public void setText(String s);

    static final String ABRIR = " Abrir archivo. ";
    static final String ENCRYPT = " Encriptar. ";
    static final String DECRYPT = " Decriptar. ";
    static final String GUARDAR = " Guardar texto. ";
}
