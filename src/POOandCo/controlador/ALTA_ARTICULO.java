
package POOandCo.controlador;

import POOandCo.modelo.Articulo;
import POOandCo.vista.FormArticulo;


public class ALTA_ARTICULO {
    String codigo;
    String descripcion;
    float pvpVenta;
    float gastosEnvio;
    int tiempoPreparacion;
    Articulo setArticulo;
    FormArticulo getArticulo;
    
    
    public void ObtenDatosPedidos(){
        codigo = getArticulo.getjTextField1().getText();
        descripcion = getArticulo.getjTextField2().getText();
      //  pvpVenta = Double.parseDouble(getArticulo.getjTextField3().getText()) ;
      //  gastosEnvio = Double.parseDouble(getArticulo.getjTextField4().getText());
        tiempoPreparacion = Integer.parseInt(getArticulo.getjTextField5().getText());
    }
    
    public void GrabarDatosPedido(){
        setArticulo = new Articulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);
    }
}
