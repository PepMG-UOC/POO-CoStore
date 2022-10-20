
package POOandCo.controlador;

import POOandCo.modelo.Articulo;



public class ALTA_ARTICULO {
    String codigo;
    String descripcion;
    float pvpVenta;
    float gastosEnvio;
    int tiempoPreparacion;
    Articulo setArticulo;

    
    
    public void ObtenDatosPedidos(){
      
    }
    
    public void GrabarDatosPedido(){
        setArticulo = new Articulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);
    }
}
