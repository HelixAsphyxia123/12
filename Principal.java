/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcfinal;
import javax.swing.JFrame ;
/**
 *
 * @author valti
 */
public class Principal {
    public static void main ( String [] args )
{
Modelo mo = new Modelo () ;
Vista vi = new Vista () ;
Controlador c = new Controlador (mo, vi) ;
c. arrancar () ; // Arranca la interfaz ( vista )
}
}
