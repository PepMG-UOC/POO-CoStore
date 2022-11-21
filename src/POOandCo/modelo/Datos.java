
package POOandCo.modelo;

import POOandCo.dao.*;
import POOandCo.idao.*;

import java.util.List;
import java.util.ArrayList;
import jdk.dynalink.NamedOperation;
import java.time.LocalDateTime;

public class Datos {    
    private Articulo articulo;
    private Cliente cliente;
    private ClienteEstandard clienteStd;
    private ClientePremium clientePrm;
    private Pedido pedido;
 
       
    public Datos (){        
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
        DaoCliente dao= new ClienteDAOImpl();
        try {
            lista = dao.listarPRM();
            
        } catch (Exception e) {
            throw new RuntimeException(e);            
        }
        return lista;      
    }

    public List<Pedido> getListaPedidos() {
        List<Pedido> lista = new ArrayList<>();
        DaoPedido dao = new PedidoDAOImpl();
        try {
            lista = dao.listarPedidos();
        } catch (Exception e) {
            throw new RuntimeException(e);                      
        }
        return lista; 
    }

    public List<Pedido> getEnviadosByCliente(String eMail) {
        List<Pedido> listaCompleta = new ArrayList<>();
        List<Pedido> listaByCliente = new ArrayList<>();
        listaCompleta = getListaPedidos();
        for(int item=0; item<(listaCompleta.size()); item++){
            if(pedidoEnviado(listaCompleta, item)){
                if(listaCompleta.get(item).getCliente().geteMail().equals(eMail)){
                    listaByCliente.add(listaCompleta.get(item));                
                }                                
            }
        } 
        return listaByCliente;
    }

    public List<Pedido> getPendienteByCliente(String eMail) {
        List<Pedido> listaCompleta = new ArrayList<>();
        List<Pedido> listaByCliente = new ArrayList<>();
        listaCompleta = getListaPedidos();
        for(int item=0; item<(listaCompleta.size()); item++){
            if(!pedidoEnviado(listaCompleta, item)){
                if(listaCompleta.get(item).getCliente().geteMail().equals(eMail)){
                    listaByCliente.add(listaCompleta.get(item));                
                }                                
            }
        } 
        return listaByCliente;
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

    public int pedidoByNum(int numPedido){
        List<Pedido> lista = new ArrayList<>();
        lista = getListaPedidos();
        for(int item=0; item<(lista.size()); item++) {
            if (numPedido==(lista.get(item).getNumPedido())){
                  return item;
            }
          }
          return -1;
      } 

    
    public Articulo getArticulo()
    {
        return articulo;
    }   

    public boolean pedidoEnviado(List<Pedido> lista,int item){
         LocalDateTime fechahoraPedido;
         LocalDateTime fechahoraAhora= LocalDateTime.now();  
         int tiempoPrepara;
         fechahoraPedido=lista.get(item).getFechaYhora();
         tiempoPrepara=lista.get(item).getArticulo().getTiempoPreparacion();
         if (fechahoraPedido.plusMinutes(tiempoPrepara).isBefore(fechahoraAhora)) {
            return true; 
         }
         return false;
     }

     public void borrarPedido(int id_Pedido) {
        DaoPedido dao= new PedidoDAOImpl();
        try
        {
            dao.borrarPedido(id_Pedido);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    
}
