
package POOandCo.modelo;

import POOandCo.dao.*;
import POOandCo.idao.*;

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
        DaoArticulo dao= new ArticuloDaoImpl();
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
        DaoCliente dao= new ClienteDAOImpl();
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


    public boolean setPedido(int numPedido, Articulo articulo,int cantidad, Cliente cliente)
    {   
        boolean success=false;
        pedido=new Pedido(numPedido,articulo,cantidad,cliente);
        DaoPedido dao= new PedidoDAOImpl();
        try {
            success = dao.registrar(pedido);            
        } catch (Exception e) {
            success = false;
            throw new RuntimeException(e);
        }
        return success;
    }

    public Cliente clienteByEmail(String eMail){
        List<Cliente> lista = getListaClientes();
        if(lista!=null) {
            for(int item=0; item<(lista.size()); item++) {
                if (eMail.equals(lista.get(item).geteMail())){
                    return lista.get(item);
                } 
            }
        }
        return null;
    }

    public Articulo getArticuloByCodigo (String codigo)
    {
        DaoArticulo dao= new ArticuloDaoImpl();
        articulo = dao.getArticuloDAOById(codigo);
        return articulo;
    }

    public List<Cliente> getListaClientes(){              
        Cliente cliente;
        DaoCliente dao= new ClienteDAOImpl();
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
        DaoCliente dao= new ClienteDAOImpl();
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
        DaoCliente dao= new ClienteDAOImpl();
        try {
            lista = dao.listarPRM();
            
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return lista;      
    }

    public int getNumeroPedido(){
        int numPedido=0;
        DaoPedido dao= new PedidoDAOImpl();
        try {
            numPedido=dao.getNumPedido();
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return numPedido;
    }
    
    public Articulo getArticulo()
    {
        return articulo;
    }   

   
    
    
}
