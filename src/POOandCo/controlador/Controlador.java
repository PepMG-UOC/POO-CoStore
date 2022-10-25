
package POOandCo.controlador;

import java.util.List;
import POOandCo.modelo.Datos;
import POOandCo.vista.*;
import java.util.ArrayList;

public class Controlador {
    private Datos datos;
    private ArticuloVista articuloView = new ArticuloVista();   

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
                    //añadirClientePremium();
                    break;
                case '3':
                    //darBajaCliente();
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
            articuloView.warning(codigo);
            return;
        }
        datos.setArticulo(codigo,articuloView.descripcionArticulo(),articuloView.pvpVentaArticulo(),articuloView.gastosEnvioArticulo(),articuloView.tiempoPreparacionArticulo());        
        datos.addArticuloToList(datos.getArticulo()); 
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
    
    
  /*  public int clienteByTipo(String tipo){
        for(int item=0; item<(datos.getListaClientes().getLista().size()); item++) {
            if (tipo.equals(datos.getListaClientes().getLista().get(item).tipoCliente())){
                return item;
            }
        }
        return -1;
    }*/
    
    public int ArticuloByCodigo(String codigo){
        
        for(int item=0; item<(datos.getListaArticulos().getLista().size()); item++) {
         if (codigo.equals(datos.getListaArticulos().getLista().get(item).getCodigo())){
             return item;
         }
        }
        return -1;        
    }

    

    

}
