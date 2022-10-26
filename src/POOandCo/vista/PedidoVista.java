
package POOandCo.vista;

import java.util.Scanner;


import java.time.LocalDateTime;


public class PedidoVista {
    Scanner teclado = new Scanner(System.in);

    public char menuPrincipal() {
        char opcion;
        System.out.println();
        System.out.println("1. Añadir Pedido");
        System.out.println("2. Eliminar Pedido");
        System.out.println("3. Mostar pedidos pendientes de envío");
        System.out.println("4. Mostar pedidos enviados");
        System.out.println("0. Salir");
        opcion = pedirOpcion();
           
        return opcion; 
    }
    
    char pedirOpcion() {
        String resp;
        System.out.print("Elige una opción (1,2,3 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);        
    }
    
    public void adCabecera(){
        System.out.println(); 
        System.out.println("===== Introducir Pedido =====");
        System.out.println(); 
    }

    public int numPedido(){
        int numPedido;
        System.out.print("Numero de pedido: ");
        numPedido = teclado.nextInt();
        teclado = new Scanner(System.in);
        return numPedido;
    }

    public int cantidadPedido(){
        int cantidad;
        System.out.print("Cantidad: ");
        cantidad=teclado.nextInt();
        teclado= new Scanner(System.in);
        return cantidad;       
    }
            
    public void showpvpVenta(float pvpVentaArticlulo, int cantidad){
        System.out.println("Pvp Venta Artculo: " + pvpVentaArticlulo);
        System.out.println("Total pedido: " + cantidad*pvpVentaArticlulo);
    }

    public void warning(int numPedido, boolean exist){
        System.out.print("El pedido " + numPedido);
        if (exist) System.out.print(" ya existe.");
        else System.out.print(" no existe");
        System.out.println(); 
    }    
   
}
