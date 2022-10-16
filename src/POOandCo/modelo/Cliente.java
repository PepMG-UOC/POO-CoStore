
package POOandCo.modelo;

/**
 * Esta clase representara los clientes de la tienda.
 * @author Pep Margarit
 * @version 1.0 
 */
public abstract class Cliente {
    private String eMail;
    private String nombre;
    private String domicilio;
    
    //Tengo entendido que en java no se pueden crear variables abstractas
    //entra en contradiccion lo que se nos pide???
    
    //public abstract String tipoCliente();

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
   
    
    
}
