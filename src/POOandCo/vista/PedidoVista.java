
package POOandCo.vista;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


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



    public String getArticuloPedido(){

        String codigo;
        System.out.print("Codigo del articulo: ");
        codigo= teclado.nextLine();
        return codigo;
    }




    public int cantidad(){

    
       /*  //if (controlador.clienteByEmail(eMail)==-1){    
          //   vistaCliente.addCliente();
        } 
        else {
            System.out.print("Codigo del articulo: ");
            codigo = teclado.nextLine();
            if (controlador.articuloByCodigo(codigo)==-1){    
             System.out.print("El articulo no existe.");
             System.out.println();
             return -1; 
            } 
            else {
                
            }
        }   */
        return 1;
    }

    public void warning(int numPedido, boolean exist){
        System.out.print("El pedido " + numPedido);
        if (exist) System.out.print(" ya existe.");
        else System.out.print(" no existe");
        System.out.println(); 
    }
    
}
