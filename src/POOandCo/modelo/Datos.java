
package POOandCo.modelo;

import POOandCo.idao.ArticuloDaoImpl;
import POOandCo.dao.DAO;
import POOandCo.idao.ClienteDAOImpl;
import POOandCo.idao.PedidoDAOImpl;
import java.util.List;
import java.util.ArrayList;
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


    public boolean setPedido(int cantidad, String articulo, String eMail)
    {
        pedido=new Pedido(cantidad,articulo,eMail);
        DAO dao= new PedidoDAOImpl();
        try {
            if (dao.registrar(pedido)==false)
            {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Articulo getArticuloByCodigo (String codigo)
    {
        DAO dao= new ArticuloDaoImpl();
        articulo = dao.getArticuloDAOById(codigo);
        return articulo;
    }

    public List<Cliente> getListaClientes(){              
        Cliente cliente;
        DAO dao= new ClienteDAOImpl();
        try {
            List lista = dao.listarSTD();
            lista.addAll(dao.listarPRM());
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }        
    }

    public List<Cliente> getListaClientesSTD(){   
        List<Cliente> lista = new ArrayList<>();           
        Cliente cliente;
        DAO dao= new ClienteDAOImpl();
        try {
            lista = dao.listarSTD();
            
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return lista;      
    }

    public List<Cliente> getListaClientesPRM(){   
        List<Cliente> lista = new ArrayList<>();           
        Cliente cliente;
        DAO dao= new ClienteDAOImpl();
        try {
            lista = dao.listarPRM();
            
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return lista;      
    }


    /* public void getTodosClientes ()
    {
        DAO dao= new ClienteDAOImpl();
        dao.clientesDAO();

    } */


    public void getClientesEstandard ()
    {
        DAO dao= new ClienteDAOImpl();
        dao.clientesDAOEst();

    }

    public void getClientesPremium ()
    {
        DAO dao= new ClienteDAOImpl();
        dao.clientesDAOPre();

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

    /*
    public void setPedido (int numPedido, Articulo articulo, int cantidad, Cliente cliente) {
        pedido = new Pedido(numPedido,articulo,cantidad,cliente);
        listaPedidos.add(pedido);
    }

     */
     
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    /* public ListaClientes getListaClientes() {
        return listaClientes;
    } */

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }
    
    
}
