
package POOandCo.modelo;


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private Articulo articulo;
   // private ClienteEstandard clienteStd;
   // private ClientePremium clientePrm;
   // private Lista<Articulo> listart;
    
    public Datos (){
       // listart = new Lista<>();
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
        
        
       // listart.lista.add(articulo);
        //articulo = new Articulo();
       // listaArticulos.lista.add(e);
    }
    
   
// TO-BE-DONE
    public void setArticulo (String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setDescripcion(descripcion);
        articulo.setPvpVenta(pvpVenta);
        articulo.setGastosEnvio(gastosEnvio);
        articulo.setTiempoPreparacion(tiempoPreparacion);    
        addArticulos(articulo);
    }
    
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ListaArticulos listaArticulos) {
        
        this.listaArticulos = listaArticulos;
    }

    public void addArticulos(Articulo articulo) {
        listaArticulos.add(articulo);
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ListaPedidos listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
