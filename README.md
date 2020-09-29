"En este apartado se mostrara lo visto en este proyecto y sus caracterisicas como otras"

Usando 100% Java.

Problematica a desarrollar:

#Desarrollar un programa que implemente una aplicación con GUI para el cifrado de archivos de texto con el algoritmo de cifrado Vigenère.#

Se va a crear un programa de cifrado simple. El proceso es muy sencillo. Se divide en dos partes.
 En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres posiciones
hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe convertirse en la letra
’d’, la letra ’y’ debe convertirse en el carácter ’—’, etc. En segundo lugar, cada línea debe
invertirse. Después de invertir, todos los caracteres de la mitad en adelante (truncado) deben
moverse una posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’ se
convierte en ’‘’.
Por ejemplo, si como entrada tenemos la cadena abcABC1 si la palabra resultante de la
primera parte es ”defDEF1”, las letras ”DEF1”deben moverse una posición a la izquierda.
Sin embargo, si la palabra resultante de la primera parte es ”tesA”, las letras ”sA”serán
desplazadas. El resultado cifrado de la cadena es 1FECedc.

Pre-requisitos 📋
Se necesita tener las librerias, el github y un IDE.
NetBeans 8.2 y GIT

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.io.BufferedReader;             //LIBRERIAS UTILIZADAS
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import static mvcfinal.InterfazVista.ABRIR; //Usada para abrir conectar la interfazvista con la accion de abrir.
import static mvcfinal.InterfazVista.DECRYPT; //Usada para decriptar.
import static mvcfinal.InterfazVista.ENCRYPT; //Usada para encriptar.
import static mvcfinal.InterfazVista.GUARDAR; //Usada para guardar el archivo generado apartir de nuestra encriptacion.

--Algoritmo de encriptado, desencriptado, escribir y guardar para el archivo generado.

class Modelo {

    private String contenido;
    private String fileName;
    final char shiftup = (char) 3;
    final char shiftdown = (char) 1;

    public void setContenido(String texto) {
        contenido = texto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setFileName(String nombre) {
        fileName = nombre;
    }

    public String encriptar() {
        String ctext = "";
        for (String linea : contenido.split("\n")) {
            StringBuilder cadena = new StringBuilder();
            for (char c : linea.toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftup;
                }
                cadena.append(c);
            }

            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = cadena.reverse().toString();

            int h = shifttext.length() / 2;
            for (char c : shifttext.substring(h,
                    shifttext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c -= shiftdown;
                }
                shift_cadena.append(c);
            }
            ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + '\n';
        }
        contenido = ctext;
        return ctext;
    }

    public String desencriptar() {
        String texto = "";
        for (String ctext : contenido.split("\n")) {
            int h = ctext.length() / 2;
            StringBuilder shift_cadena = new StringBuilder(ctext.substring(0, h));

            for (char c : ctext.substring(h, ctext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftdown;
                }
                shift_cadena.append(c);
            }

            String shifttext = shift_cadena.reverse().toString();
            StringBuilder cadena = new StringBuilder();

            for (char c : shifttext.toCharArray()) {
                if (Character.isLetter(c - 3)) {
                    c -= shiftup;
                }
                cadena.append(c);
            }
            texto = texto + cadena.toString() + '\n';
        }
        contenido = texto;
        return texto;
    }

    public String read() {
        String cad;
        String content = "";
        File file = new File(fileName);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((cad = b.readLine()) != null) {
                    content = content + cad + '\n';
                }
                b.close();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error opening file .");
        } catch (IOException ioException) {
            System.err.println(" Error reading file .");
        }
        contenido = content;
        return content;
    }

    public void write() {
        try {
            File archivo = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    archivo));
            bw.write(contenido);
            bw.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error opening file .");
        } catch (IOException ioException) {
            System.err.println(" Error reading file .");
        }
    }
}


Se coloca el nombre del archivo en el textLabel, despues en el textArea se coloca la informacion.
1.- Guardar(Se almacena la informacion en el archvio).
2.- Encripta(Se aplica el metodo usado para encriptar).
3.- Desencriptar(Se revierte el efecto de encriptar para obtener el texto original).
4.- Abrir archivo(Se busca el nombre del archivo que se ingreso antes para ver la informacion almacenada).

Pueden utilizar estas cadenas como prueba
Texto #3
abcABC1
vxpdylY .ph
vv.xwfxo.fd
	
Cadenas resultantes (respectivamente)
3# rvzgV
1FECedc
ks. \n{frzx
gi.r{hyz-xx.





