
package POOandCo.modelo;


public abstract class Cliente {
    private String eMail;
    private String nombre;
    private String domicilio;
    public String tipo;
    public float calculo;
    public float descuento;
  

    //public abstract float calcAnual();

    //public abstract float descuentoEnv();
    

    public Cliente(String eMail, String nombre, String domicilio) {
        this.eMail = eMail;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
   
    
    
    //metodos abstractos
    
    public abstract String tipoCliente();

    public abstract float calcAnual();

    public abstract float descuentoEnv();
    
    
    
}
