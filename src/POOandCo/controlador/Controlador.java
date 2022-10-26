
package POOandCo.controlador;

import java.util.List;

import POOandCo.modelo.*;
import POOandCo.vista.*;
import java.util.ArrayList;

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



    public void menuPedido() {
        char resultado;
        boolean salir = false;
        do {
            resultado = pedidoVista.menuPrincipal();
            switch (resultado) {
                case '1':
                    añadirPedido();
                    break;
                case '2':

                    break;
                case '3':

                    break;
                case '4':

                    break;

            }
            if (resultado == '0') salir = true;
        } while (!salir);
    }




    private void añadirArticulo() {
        String codigo;
        articuloView.adCabecera();
        codigo = articuloView.codigoArticulo();
        if (articuloByCodigo(codigo)!=-1)
        {
            articuloView.warning(codigo,true);
            return;
        }
        datos.setArticulo(codigo,articuloView.descripcionArticulo(),articuloView.pvpVentaArticulo(),articuloView.gastosEnvioArticulo(),articuloView.tiempoPreparacionArticulo());        
        datos.addArticuloToList(datos.getArticulo()); 
    }

    private void añadirCliente() {
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

    public int articuloByCodigo(String codigo){        
        for(int item=0; item<(datos.getListaArticulos().getLista().size()); item++) { 
         if (codigo.equals(datos.getListaArticulos().getLista().get(item).getCodigo())){
             return item;
         }
        }
        return -1;        
    }
    
    public int clienteByEmail(String eMail){
         for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
            if (eMail.equals(datos.getListaClientes().getLista().get(item).geteMail())){
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


// AÑADIR PEDIDO

    Articulo getarticulos(String codigo){
        for(Articulo art : datos.getListaArticulos().getLista()){
            if(art.getCodigo().equals(codigo)){
                return art;
            }
        }
        return null;
    }


    Cliente getClientes(String eMail){
        for(Cliente cli : datos.getListaClientes().getLista()){
            if(cli.geteMail().equals(eMail)){
                return cli;
            }
        }
        return null;
    }


    boolean existeCliente(String eMail){
        for (Cliente cli : datos.getListaClientes().getLista()){
            if (cli.geteMail().equals(eMail)){
                return true;
            }
        }
        return false;
    }


    private void añadirPedido() {

        Articulo art = null;
        Cliente cli = null;

        int numPedido;
        pedidoVista.adCabecera();
        numPedido = pedidoVista.numPedido();

        if (pedidoByNum(numPedido)!=-1)
        {
            pedidoVista.warning(numPedido,true);
            return;
        }

        String codigo;
        articuloView.codigoArticulo();
        codigo = articuloView.codigoArticulo();
        art = getarticulos(codigo);

        //comprobar si el email añadido corresponde a un cliente y si no, añadir cliente la pedido

        String eMail;
        clienteVista.eMailCliente();
        eMail = clienteVista.eMailCliente();

        if (existeCliente(eMail)){
            cli = getClientes(eMail);
            return;
        }else{
           añadirCliente();
           cli = getClientes(eMail);
        }

        datos.setPedido(numPedido, art, pedidoVista.cantidad(), cli);
        datos.addPedidoToList(datos.getPedido());
        System.out.println("pedido añadido");
    }


    /*
    private void muestraPedido() {
        int numPedido;
        pedidoVista.adCabecera();
        numPedido = pedidoVista.numPedido();
        if (pedidoByNum(numPedido)!=-1) {
            pedidoVista.showArticulo( datos.getListaArticulos().getLista().get(articuloByCodigo(numPedido)).toString());
        }
        else {
            pedidoVista.warning(numPedido,false);
        }
    }

     */



    public int pedidoByNum(int numPedido){
        for(int item=0; item<(datos.getListaPedidos().getLista().size()); item++) {
            if (numPedido==(datos.getListaPedidos().getLista().get(item).getNumPedido())){
                return item;
            }
        }
        return -1;
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
