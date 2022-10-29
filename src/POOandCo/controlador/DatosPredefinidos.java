package POOandCo.controlador;

import POOandCo.modelo.Datos;

/**
 *
 * @author Pep
 */
public class DatosPredefinidos {
    /**
     * Esta clase solo carga algunos datos de Articulos y Clientes para demostracion del codigo.
     */    
        
    public void Carga(Datos datos){
        String codigo;
        String descripcion;
        float pvpVenta;
        float gastosEnvio;
        int tiempoPreparacion;

        String eMail;
        String nombre;
        String domicilio;
        String nif;
        String tipo;        
        
        int numPedido;
        int cantidad;
        
        //Articulos
        codigo= "1A";
        descripcion = "Articulo 1 Precargado";
        pvpVenta = 30f;
        gastosEnvio = 10f;
        tiempoPreparacion = 5;         
        datos.setArticulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);
        //---
        codigo= "2A";
        descripcion = "Articulo 2 Precargado";
        pvpVenta = 60f;
        gastosEnvio = 20f;
        tiempoPreparacion = 10;         
        datos.setArticulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);

        //Clientes
        eMail = "uno@mail.com";
        nombre = "Juan";
        domicilio = "C/ Toledo 6 1ª";
        nif = "38439482Y";
        tipo = "1"; // Estandard
        datos.setCliente(eMail, nombre, domicilio, nif, tipo);
        //---
        eMail = "dos@mail.com";
        nombre = "Maria";
        domicilio = "C/ Pinar 12";
        nif = "49385029T";
        tipo = "1"; // Estandard
        datos.setCliente(eMail, nombre, domicilio, nif, tipo);
        //---
        eMail = "tres@mail.com";
        nombre = "Cristina";
        domicilio = "C/ Mayor 34 5º 3ª";
        nif = "538284758P";
        tipo = "2"; // Premium
        datos.setCliente(eMail, nombre, domicilio, nif, tipo);
        //---
        eMail = "cuatro@mail.com";
        nombre = "Alonso";
        domicilio = "C/ Moya 8";
        nif = "77748833U";
        tipo = "2"; // Premium
        datos.setCliente(eMail, nombre, domicilio, nif, tipo);
        
        // Pedidos
        numPedido = 01;
        cantidad = 10;
        
        datos.setPedido(numPedido, datos.getListaArticulos().getLista().get(0) , cantidad, datos.getListaClientes().getLista().get(1));
      
        numPedido = 02;
        cantidad = 5;
        datos.setPedido(numPedido, datos.getListaArticulos().getLista().get(1) , cantidad, datos.getListaClientes().getLista().get(2));
      
    }
}
