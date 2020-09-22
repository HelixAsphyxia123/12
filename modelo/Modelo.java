/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ActionEvent;

/**
 *
 * @author valti
 */
public class Modelo {
    
    private String escribe;
    private String resultado;

    public String getEscribe() {
        return escribe;
    }

    public void setEscribe(String escribe) {
        this.escribe = escribe;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

  public String encriptar(){
      this.resultado = this.escribe;
      StringBuilder builder=new StringBuilder(this.resultado);
      this.resultado=builder.reverse().toString(); 


    	return this.resultado;
        
        
        
   }
  
  /*public String desencriptar(){
      String desencriptar = this.getEscribe();
      
      StringBuilder builder=new StringBuilder(desencriptar);
      desencriptar=builder.reverse().toString(); 


    	return desencriptar;
        
        
        
  */ 
  
  
  
    
   


 
}
