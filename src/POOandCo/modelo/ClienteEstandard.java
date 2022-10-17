/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POOandCo.modelo;

/**
 *
 * @author Hernan
 */
public class ClienteEstandard extends Cliente{


    public ClienteEstandard(String eMail, String nombre, String domicilio) {
        super(eMail, nombre, domicilio);

    }
    
    public String tipoCliente() {
        return tipo; 
    } 
    
      public float calcAnual() {
        return calculo; 
    } 
      
      
    public float descuentoEnv() {
    
        return descuento;
    
    }
    
}

