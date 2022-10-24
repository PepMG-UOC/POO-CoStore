
package POOandCo.modelo;


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private Articulo articulo;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
       
    public Datos (){
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
    }    
   
    public void setArticulo (String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setDescripcion(descripcion);
        articulo.setPvpVenta(pvpVenta);
        articulo.setGastosEnvio(gastosEnvio);
        articulo.setTiempoPreparacion(tiempoPreparacion);    
        addArticulos(articulo);
    }
    
     public void addArticulos(Articulo articulo) {
        listaArticulos.add(articulo);
    }
    
     
    public void setClienteStd(String eMail, String nombre, String domicilio, String nif){
        clienteStd = new ClienteEstandard(eMail,nombre,domicilio,nif);
        clienteStd.calcAnual();
        
    }
     
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ListaArticulos listaArticulos) {
        
        this.listaArticulos = listaArticulos;
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
