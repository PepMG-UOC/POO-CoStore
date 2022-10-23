
package POOandCo.controlador;

import java.util.List;
import POOandCo.modelo.Datos;
import POOandCo.vista.*;
import java.util.ArrayList;

public class Controlador {
    private Datos datos;
    //private ArrayList<Lista> lista;
    
   // private ArrayList<Articulo> listaArticulo = new ArrayList<>();
    
    public Controlador() {
        datos = new Datos ();
        
    }

       
    public void _Articulo(String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        datos.setArticulo ( codigo,  descripcion,  pvpVenta,  gastosEnvio,  tiempoPreparacion);
      //  datos.setArticulo(codigo, descripcion, 0, 0, 0);
    }
    
    
    
    public int ArticuloByCodigo(String codigo){
        
        for(int item=0; item<(datos.getListaArticulos().getLista().size()); item++) { 
         if (codigo.equals(datos.getListaArticulos().getLista().get(item).getCodigo())){
             return item;
         }
        }
        return -1;        
    }
    
// TO-BE-DON

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {        
        this.datos = datos;
    }

    

}
