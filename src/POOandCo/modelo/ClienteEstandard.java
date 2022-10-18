
package POOandCo.modelo;


public class ClienteEstandard extends Cliente{
    
    private float calculo;
    private float descuento;

    public ClienteEstandard(String eMail, String nombre, String domicilio, String nif) {
        super(eMail, nombre, domicilio, nif);
    }
    
    
    @Override
    public String tipoCliente() {
        return tipo="Standard"; 
    } 
    
    @Override
      public float calcAnual() {
        return calculo=0; 
    } 
      
      
    @Override
    public float descuentoEnv() {    
        return descuento=1;    
    }
    
}

