
package POOandCo.modelo;

import POOandCo.idao.ArticuloDaoImpl;
import POOandCo.dao.DAO;
import POOandCo.idao.ClienteDAOImpl;
import jdk.dynalink.NamedOperation;

public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private Articulo articulo;
    private Cliente cliente;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
    private Pedido pedido;
 
       
    public Datos (){
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos ();
        
    }

    //IMPLEMENTADO FACTORY
    public boolean setArticulo(String codigo, String descripcion, float pvpVenta, float gastosEnviom, int tiempoPreparacion)
    {
        articulo=new Articulo(codigo,descripcion,pvpVenta,gastosEnviom,tiempoPreparacion);
        DAO dao= new ArticuloDaoImpl();
        try {
            if (dao.registrar(articulo)==false)
            {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return true;
    }
   
    public boolean setCliente(String eMail, String nombre, String domicilio, String nif, String tipo){
        boolean success=false;
        DAO dao= new ClienteDAOImpl();
        try {
            if (tipo.equals("1")) {
                cliente = new ClienteEstandard(eMail,nombre,domicilio,nif);                               
            } 
            else if(tipo.equals("2")) {
                cliente = new ClientePremium(eMail,nombre,domicilio,nif);                              
            } 
            success = dao.registrar(cliente);           
        } catch (Exception e) {
            success = false;
            throw new RuntimeException(e);
        }
        return success;
    } 

    public Articulo getArticuloByCodigo (String codigo)
    {
        DAO dao= new ArticuloDaoImpl();
        articulo = dao.getArticuloDAOById(codigo);
        return articulo;
    }


    /* public Cliente getCliente1()
    {
        return clienteStd;
    }

    public Cliente getCliente2()
    {
        return clientePrm;
    } */

    
    public Articulo getArticulo()
    {
        return articulo;
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
