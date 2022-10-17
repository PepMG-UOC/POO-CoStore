/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POOandCo.modelo;

/**
 *
 * @author Hernan
 */
public class ClientePremium extends Cliente{
    
    private float cuota;
    private float descuento;
    
        public ClientePremium(String eMail, String nombre, String domicilio) {
        super(eMail, nombre, domicilio);
        this.cuota = cuota;
        this.descuento = descuento;

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
