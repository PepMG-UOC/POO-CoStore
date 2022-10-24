
package POOandCo.vista;

import java.util.Scanner;
import POOandCo.controlador.Controlador;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PedidoView {
     Scanner teclado = new Scanner(System.in);
     static Controlador controlador;
     private int numPedido;
     //private Articulo articulo;
     private int cantidad;
    // private Cliente cliente;
     private LocalDate fecha;
     private LocalTime hora;
     private LocalDateTime fechaYhora;
      
     public PedidoView(Controlador controlador) {
        this.controlador = controlador;
     }     
     
    ArticuloView vistaAarticulo = new ArticuloView(controlador);
    ClienteView vistaCliente = new ClienteView(controlador);
    
     public void menu() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println();
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostar pedidos pendientes de envío");
            System.out.println("4. Mostar pedidos enviados");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    addPedido();
                    break;
                case '2':
                    ;
                    break;
                case '3':
                    ;
                    break;
                case '4':
                    ;
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
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
    
    public void addPedido(){
      
        vistaCliente.addCliente();
        
    }
    
}
