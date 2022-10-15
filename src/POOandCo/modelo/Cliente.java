
package POOandCo.modelo;

/**
 * Esta clase representara los clientes de la tienda.
 * @author Pep Margarit
 * @version 1.0 
 */
public class Cliente {
    private String eMail;
    private String nombre;
    private String domicilio;
    private String nif;
    private boolean esPremium;
    private double cuota;
    private double descuento;
    
    
    /**
     * Crea un nuevo Cliente
     * @param eMail         eMail del Cliente
     * @param nombre        Nombre del Cliente
     * @param domicilio     Direccion del Cliente
     * @param nif           nif/dni del Cliente
     * @param esPremium     Indica si el cliente esta Abonado
     * @param cuota         Indica la cantidad a pagar para ser premium.
     * @param descuento     Indica la cantidad a descontar en los envios.
     */
    public Cliente(String eMail, String nombre, String domicilio, String nif) {
        this.eMail = eMail;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.esPremium = false;
    }
    public Cliente(String eMail, String nombre, String domicilio, String nif, double cuota, double descuento) {
        this.eMail = eMail;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.esPremium = true;
        this.cuota = cuota;
        this.descuento = descuento;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    
    
    
    /**
     * Representacion de los datos de un Cliente
     * @return un string que representa los datos de un Cliente
     */
    @Override
    public String toString(){
        return "eMail:" + this.eMail + "\n"
             + "NIF: " + this.nif + "\n"              
             + "Nombre: " + this.nombre + "\n" 
             + "Domicilio: " + this.domicilio + "\n"
             + "Esta Abonado: " + this.esPremium + "\n" ;
    }
    
}
