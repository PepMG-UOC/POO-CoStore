
package POOandCo.controlador;

import POOandCo.idao.PedidoDAOImpl;
import POOandCo.modelo.Datos;
import POOandCo.vista.*;
import java.util.List;
import java.time.LocalDateTime;

import com.mysql.cj.jdbc.result.ResultSetFactory;


public class Controlador {
    private Datos datos;
    private ArticuloVista articuloView = new ArticuloVista(); 
    private ClienteVista clienteVista = new ClienteVista();  
    private PedidoVista pedidoVista = new PedidoVista();
    

    public Controlador() {
        datos = new Datos ();       
    }
    
    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {        
        this.datos = datos;
    }   
    
    public void menuArticulo() {
        char resultado;
        boolean salir = false;
        do {
            resultado = articuloView.menuPrincipal();
            switch (resultado) {
                case '1':
                    añadirArticulo();
                    break;
                case '2':                    
                    muestraArticulo();
                    break;
                }
                if (resultado == '0') salir = true;
            } while (!salir);
    }

    public void menuCliente() {
        char resultado;
        boolean salir = false;
        do {
            resultado = clienteVista.menuPrincipal();
            switch (resultado) {
                case '1':                    
                    añadirCliente();
                    break;
                case '2':
                    muestraClientes();
                    break;
                case '3':
                    showClientesPorTipo("Estandard");
                    break;
                case '4':
                    showClientesPorTipo("Premium");
                    break;

                }
                if (resultado == '0') salir = true;
            } while (!salir);
    }

    public void menuPedido(){
        char resultado;
        boolean salir = false;
        do {
            resultado = pedidoVista.menuPrincipal();
            switch (resultado) {
                case '1':
                    añadirPedido();
                    break;
                case '2':
                    eliminarPedido();
                    break;
                case '3':                    
                    pedidosPendientes();
                    break;
                case '4':
                    pedidosEnviados();
                    break;

                }
                if (resultado == '0') salir = true;
            } while (!salir);
    }

    public void añadirArticulo()
    {
        boolean success;
        articuloView.adCabecera();
        success = datos.setArticulo(articuloView.codigoArticulo(), articuloView.descripcionArticulo(), articuloView.pvpVentaArticulo()
                ,articuloView.gastosEnvioArticulo(),articuloView.tiempoPreparacionArticulo());
        if(!success) {
            articuloView.warning(datos.getArticulo().getCodigo(),true);
        }        
    }
     
    public void añadirCliente() {
        boolean success;
        String eMail;
        clienteVista.adCabecera();
        eMail = clienteVista.eMailCliente();
        success = datos.setCliente(eMail, clienteVista.nombreCliente(), clienteVista.domicilioCliente()
                ,clienteVista.nifCliente(), clienteVista.tipoCliente());  
        if(!success) {
            clienteVista.warning(eMail,true);
        }      
    }

    public void añadirPedido()
    {          
        int numPedido;
        String eMail;
        String codigo;           
        float gastos;  
        float descuento;
        int cantidad;
        boolean success;
         
        pedidoVista.adCabecera();
        numPedido = datos.getNumeroPedido();
        numPedido++;
        pedidoVista.showNumPedido(numPedido);
        eMail = clienteVista.eMailCliente();        
        if (datos.clienteByEmail(eMail)==null)
        {
            clienteVista.warning(eMail,false);
            añadirCliente();            
        } 
        codigo = articuloView.codigoArticulo();         
        if (datos.getArticuloByCodigo(codigo)==null)
        {
            articuloView.warning(codigo,false);
            return;
        } 
        gastos= datos.getArticuloByCodigo(codigo).getGastosEnvio();
        descuento = datos.clienteByEmail(eMail).descuentoEnv();
        cantidad =  pedidoVista.cantidadPedido();
        pedidoVista.showpvpVenta(datos.getArticuloByCodigo(codigo).getPvpVenta(), cantidad);
        pedidoVista.showGastosEnvio(gastos, descuento);
        success = datos.setPedido(numPedido,datos.getArticuloByCodigo(codigo), cantidad, datos.clienteByEmail(eMail));
        if(!success) {
            pedidoVista.warning(numPedido,true);
            return;
        }
    }

    private void muestraClientes() {        
        clienteVista.showCabecera();
        List lista = datos.getListaClientes();   
        if (lista!=null){
            for(int item=0; item<(lista.size()); item++) {
                clienteVista.showClientes(lista.get(item).toString());
            }
        }  
    }

    private void showClientesPorTipo(String tipo){
        if (tipo.equals("Estandard")) {
            clienteVista.showCabeceraSTD();  
            List lista = datos.getListaClientesSTD();   
            if (lista!=null){
                for(int item=0; item<(lista.size()); item++) {
                    clienteVista.showClientes(lista.get(item).toString());
                }
            }         
        }
        else {
            clienteVista.showCabeceraPRM();  
            List lista = datos.getListaClientesPRM();   
            if (lista!=null){
                for(int item=0; item<(lista.size()); item++) {
                    clienteVista.showClientes(lista.get(item).toString());
                }
            }         
        }
    }
  
    private void muestraArticulo() {
        String codigo;
        articuloView.showCabecera();
        codigo=articuloView.codigoArticulo();        
        if (datos.getArticuloByCodigo(codigo)!=null)
        {
            articuloView.showArticulo( datos.getArticulo().toString());
        } else articuloView.warning(codigo,false);
    }


    public void pedidosPendientes(){
        pedidoVista.showPdteCabecera();        
        char resultado;
        boolean salir = false;
        do {
            resultado = pedidoVista.menuMostrar();
            switch (resultado) {
                case '1':
                    allPedidosPdte();
                    break;
                case '2':
                    pedidoPendienteFiltro();
                    break;

                }
                if (resultado == '0') salir = true;
            } while (!salir);
        }

    public void allPedidosPdte(){
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++){
            if(!pedidoEnviado(item)){
                pedidoVista.showPedido(datos.getListaPedidos().getLista().get(item).toString());                
            }
        }
    }

    public void pedidoPendienteFiltro(){
        String eMail;
        eMail = clienteVista.eMailCliente();
        if (datos.clienteByEmail(eMail)==null)
        {
            clienteVista.warning(eMail,false);
            return;
        }   
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++){
            if(!pedidoEnviado(item)){
                if(datos.getListaPedidos().getLista().get(item).getCliente().geteMail().equals(eMail)){
                    pedidoVista.showPedido(datos.getListaPedidos().getLista().get(item).toString());
                }                                
            }
        } 
    }

    public void pedidosEnviados(){
        pedidoVista.showEnviosCabecera();        
        char resultado;
        boolean salir = false;
        do {
            resultado = pedidoVista.menuMostrar();
            switch (resultado) {
                case '1':
                    allPedidosEnviados();
                    break;
                case '2':
                    pedidoEnviadoFiltro();
                    break;

                }
                if (resultado == '0') salir = true;
            } while (!salir);
        }

        
    public void allPedidosEnviados(){
        pedidoVista.showEnviosCabecera();
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++){
            if(pedidoEnviado(item)){
                pedidoVista.showPedido(datos.getListaPedidos().getLista().get(item).toString());                
            }
        }
    }

    public void pedidoEnviadoFiltro(){
        String eMail;
        eMail = clienteVista.eMailCliente();
        if (datos.clienteByEmail(eMail)==null)
        {
            clienteVista.warning(eMail,false);
            return;
        }   
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++){
            if(pedidoEnviado(item)){
                if(datos.getListaPedidos().getLista().get(item).getCliente().geteMail().equals(eMail)){
                    pedidoVista.showPedido(datos.getListaPedidos().getLista().get(item).toString());
                }                                
            }
        } 
    }

    public int articuloByCodigo(String codigo){        
        for(int item=0; item<(datos.getListaArticulos().getLista().size()); item++) { 
         if (codigo.equals(datos.getListaArticulos().getLista().get(item).getCodigo())){
             return item;
         }
        }
        return -1;        
    }

    public void eliminarPedido(){
        int numPedido;              
        pedidoVista.delCabecera();
        numPedido = pedidoVista.numPedido();
        if (pedidoByNum(numPedido)==-1)
        {
            pedidoVista.warning(numPedido,false);
            return;
        } 
        if(!pedidoEnviado(pedidoByNum(numPedido))){
            datos.getListaPedidos().getLista().remove(pedidoByNum(numPedido));
        }
        pedidoVista.eliminaOk(numPedido);
    }

    public boolean pedidoEnviado(int item){
        LocalDateTime fechahoraPedido;
        LocalDateTime fechahoraAhora= LocalDateTime.now();  
        int tiempoPrepara;
        fechahoraPedido=datos.getListaPedidos().getLista().get(item).getFechaYhora();
        tiempoPrepara=datos.getListaPedidos().getLista().get(item).getArticulo().getTiempoPreparacion();
        if (fechahoraPedido.plusMinutes(tiempoPrepara).isBefore(fechahoraAhora)) {
           return true; 
        }
        return false;
    }
    
    

    public int pedidoByNum(int numPedido){
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++) {
            if (numPedido==(datos.getListaPedidos().getLista().get(item).getNumPedido())){
                return item;
            }
        }
        return -1;
    }    

    /*
    private void muestraClientes() {
        clienteVista.showCabecera();
        for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
        clienteVista.showClientes(datos.getListaClientes().getLista().get(item).toString()); 
        }       
    }


   
    private void showClientesPorTipo(String tipo){
        if (tipo.equals("Estandard")) clienteVista.showCabeceraSTD();
        else clienteVista.showCabeceraPRM();
        for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
            if (tipo.equals(datos.getListaClientes().getLista().get(item).tipoCliente())){
                clienteVista.showClientes(datos.getListaClientes().getLista().get(item).toString());
            }
        }
                
    }


     */
    public int clienteByTipo(String tipo){
        for(int item=0; item<(datos.getListaClientes().size()); item++) {
            if (tipo.equals(datos.getListaClientes().get(item).tipoCliente())){
                return item;
            }
        }
        return -1;
    }
    
    
    public int ArticuloByCodigo(String codigo){
        
        for(int item=0; item<(datos.getListaArticulos().getLista().size()); item++) {
         if (codigo.equals(datos.getListaArticulos().getLista().get(item).getCodigo())){
             return item;
         }
        }
        return -1;        
    }

    

    

}
