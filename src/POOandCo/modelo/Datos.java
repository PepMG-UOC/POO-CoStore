
package POOandCo.modelo;

import POOandCo.dao.DAO;
import POOandCo.dao.DaoPedido;
import POOandCo.idao.ArticuloDaoImpl;
import POOandCo.idao.ClienteDAOImpl;
import POOandCo.idao.PedidoDAOImpl;

import java.util.List;
import java.util.ArrayList;

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
    public boolean existePedido(int id_Pedido) {
        DaoPedido dao = new PedidoDAOImpl();
        boolean existe=false;
        try {
            existe=dao.existePedido(id_Pedido);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return existe;
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

    
    public Articulo getArticulo()
    {
        return articulo;
    }   

     
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public void setListaPedidos() {
        try
        {
            DaoPedido dao = new PedidoDAOImpl();
            listaPedidos.setLista((dao.listarToPedidos().getLista()));
        }
        catch (Exception e) {
        e.printStackTrace();
    }

    }

    public ListaPedidos getListaPedidos()  {
        try {
            return listaPedidos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
