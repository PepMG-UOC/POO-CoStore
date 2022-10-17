
package POOandCo.modelo;


public class Articulo {
    private String codigo;
    private String descripcion;
    private double pvpVenta;
    private double gastosEnvio;
    private int tiempoPreparacion;
    
    
    public Articulo(String codigo, String descripcion, double pvpVenta, double gastosEnvio, int tiempoPreparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvpVenta = pvpVenta;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPvpVenta() {
        return pvpVenta;
    }

    public void setPvpVenta(double pvpVenta) {
        this.pvpVenta = pvpVenta;
    }

    public Double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + this.codigo + "\n"
             + "Descripcion: " + this.descripcion + "\n"              
             + "PVP de Venta: " + this.pvpVenta + "\n" 
             + "Gastos de envio: " + this.gastosEnvio + "\n"
             + "Tiempo preparacion: " + this.tiempoPreparacion + " minutos.\n";
    }
    
}
