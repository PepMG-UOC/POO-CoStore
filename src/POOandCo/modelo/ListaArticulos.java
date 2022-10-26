
package POOandCo.modelo;

import java.util.ArrayList;


public class ListaArticulos extends Lista<Articulo> {
    private Articulo articulo;
    
     
  /*  public void setArticulo (String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setDescripcion(descripcion);
        articulo.setPvpVenta(pvpVenta);
        articulo.setGastosEnvio(gastosEnvio);
        articulo.setTiempoPreparacion(tiempoPreparacion);    
        addArticulos(articulo);
    }*/
    
   

//he quitado este metodo y lo he añadido en la clase generica Lista.
    /*
    public ArrayList<Articulo> getLista() {
        return lista;
    }

     */

    public void setLista(ArrayList<Articulo> lista) {
        this.lista = lista;
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

   /* public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }*/
    
    
    
   // public void add(Articulo articulo){
     //   lista.add(articulo);
   // }

   
}
