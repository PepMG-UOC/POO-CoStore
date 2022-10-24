
package POOandCo.modelo;


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private Articulo articulo;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
    private Pedido pedido;
       
    public Datos (){
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
    }    
   
    public void setArticulo (String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        listaArticulos.add(articulo = new Articulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion));   
    }
        
    public void setCliente(String eMail, String nombre, String domicilio, String nif, String tipo){
        if (tipo.equals("1")) listaClientes.add(clienteStd = new ClienteEstandard(eMail,nombre,domicilio,nif));
        else listaClientes.add(clientePrm = new ClientePremium(eMail,nombre,domicilio,nif));             
    }
     
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }
    
    public void setPedido (int numPedido, Articulo articulo, int cantidad, Cliente cliente) {
        listaPedidos.add(pedido = new Pedido(numPedido,articulo,cantidad,cliente));
    }
}
