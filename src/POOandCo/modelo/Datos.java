
package POOandCo.modelo;


public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private Articulo articulo;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
    private Pedido pedido;
    private Cliente cliente;
       
    public Datos (){
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
    }    
   
    public void setArticulo (String codigo, String descripcion, float pvpVenta, float gastosEnvio, int tiempoPreparacion) {
        articulo = new Articulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);   
    }
    
    public Articulo getArticulo()
    {
        return articulo;
    }

    public void addArticuloToList(Articulo articulo) {
        listaArticulos.add(articulo);
    }
    
    public void setCliente(String eMail, String nombre, String domicilio, String nif, String tipo){
        if (tipo.equals("1")) {
            clienteStd = new ClienteEstandard(eMail,nombre,domicilio,nif);
            listaClientes.add(clienteStd);
        }             
        else if (tipo.equals("2")) {
            clientePrm = new ClientePremium(eMail,nombre,domicilio,nif);
            listaClientes.add(clientePrm);
        }              
    }

    public void setPedido (int numPedido, Articulo articulo, int cantidad, Cliente cliente) {
        pedido = new Pedido(numPedido,articulo,cantidad,cliente);
        listaPedidos.add(pedido);
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
    
    
}
