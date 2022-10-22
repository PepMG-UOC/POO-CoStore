
package POOandCo.modelo;


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
   // public Articulo articulo;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
   // private Lista<Articulo> listart;
    
    public Datos (){
       // listart = new Lista<>();
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
       // listart.lista.add(articulo);
        //articulo = new Articulo();
        
    }
    
   
// TO-BE-DONE

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
