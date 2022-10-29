
package POOandCo.controlador;

import POOandCo.modelo.Datos;
import POOandCo.vista.*;
import java.time.LocalDateTime;

/**
 *
 * @author Pep
 */
public class Controlador {
    private Datos datos;
    private ArticuloVista articuloView = new ArticuloVista(); 
    private ClienteVista clienteVista = new ClienteVista();  
    private PedidoVista pedidoVista = new PedidoVista();
    

    public Controlador() {
        datos = new Datos ();  
        DatosPredefinidos datosPredefinidos = new DatosPredefinidos();
        datosPredefinidos.Carga(datos);
        
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

    public void añadirArticulo() {
        String codigo;
        articuloView.adCabecera();
        codigo = articuloView.codigoArticulo();
        if (articuloByCodigo(codigo)!=-1)
        {
            articuloView.warning(codigo,true);
            return;
        }
        datos.setArticulo(codigo,articuloView.descripcionArticulo(),articuloView.pvpVentaArticulo(),articuloView.gastosEnvioArticulo(),articuloView.tiempoPreparacionArticulo());        
        //datos.addArticuloToList(datos.getArticulo()); 
    }

    public void añadirCliente() {
        String eMail;
        clienteVista.adCabecera();
        eMail = clienteVista.eMailCliente();
        if (clienteByEmail(eMail)!=-1)
        {
            clienteVista.warning(eMail,true);
            return;
        }              
        datos.setCliente(eMail,clienteVista.nombreCliente(),clienteVista.domicilioCliente(),clienteVista.nifCliente(),clienteVista.tipoCliente());        
    }

    private void añadirPedido(){
        int numPedido;
        String eMail;
        String codigo;   
        int itemCliente;
        int itemArticulo;   
        float gastos;  
        float descuento;
        int cantidad;
        
        pedidoVista.adCabecera();
        numPedido = pedidoVista.numPedido();
        if (pedidoByNum(numPedido)!=-1)
        {
            pedidoVista.warning(numPedido,true);
            return;
        } 
        eMail = clienteVista.eMailCliente();
        itemCliente = clienteByEmail(eMail);
        if (itemCliente==-1)
        {
            clienteVista.warning(eMail,false);
            añadirCliente();   
            itemCliente = clienteByEmail(eMail);         
        }           
        codigo = articuloView.codigoArticulo();
        itemArticulo = articuloByCodigo(codigo);
        if (itemArticulo==-1)
        {
            articuloView.warning(codigo,false);
            return;
        }

        gastos= datos.getListaArticulos().getLista().get(itemArticulo).getGastosEnvio();
        descuento= datos.getListaClientes().getLista().get(itemCliente).descuentoEnv();
        cantidad =  pedidoVista.cantidadPedido();
        pedidoVista.showpvpVenta(datos.getListaArticulos().getLista().get(itemArticulo).getPvpVenta(),cantidad);
        pedidoVista.showGastosEnvio(gastos,descuento);
        datos.setPedido(numPedido, datos.getListaArticulos().getLista().get(itemArticulo),cantidad,datos.getListaClientes().getLista().get(itemCliente));         
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
        if (clienteByEmail(eMail)==-1)
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
        if (clienteByEmail(eMail)==-1)
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

    
    public int clienteByEmail(String eMail){
         for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
            if (eMail.equals(datos.getListaClientes().getLista().get(item).geteMail())){
                return item;
            }
        }
        return -1;
    }

    public int pedidoByNum(int numPedido){
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++) {
            if (numPedido==(datos.getListaPedidos().getLista().get(item).getNumPedido())){
                return item;
            }
        }
        return -1;
    }
    
    private void muestraArticulo() {
        String codigo;
        articuloView.showCabecera();        
        codigo = articuloView.codigoArticulo();
        if (articuloByCodigo(codigo)!=-1) {
            articuloView.showArticulo( datos.getListaArticulos().getLista().get(articuloByCodigo(codigo)).toString());            
        }
        else {
            articuloView.warning(codigo,false);
        }       
    }

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

    public int clienteByTipo(String tipo){
        for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
            if (tipo.equals(datos.getListaClientes().getLista().get(item).tipoCliente())){
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
