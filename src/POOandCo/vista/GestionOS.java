
package POOandCo.vista;

import POOandCo.controlador.Controlador;

import java.util.Scanner;


public class GestionOS {
    Controlador controlador= new Controlador();
        
    public GestionOS() {
      // Controlador controlador = new Controlador();
       // controlador.datos.
    }
    Scanner teclado = new Scanner(System.in);
    ArticuloView vistaAarticulo = new ArticuloView(controlador);
    ClienteView vistaCliente = new ClienteView(controlador);
   
    public void inicio() {
               boolean salir = false;
        char opcio;
        do {
            System.out.println(); 
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                   vistaAarticulo.menu();                 
                break;
                case '2':
                    vistaCliente.menu();
                break;
                case '3':
                    menuPedidos();
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



    private void menuPedidos() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar pedidos pendientes de envio");
            System.out.println("4. Mostrar pedidos enviados");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                   // TO-BE-DONE
                break;
                case '2':
                    // TO-BE-DONE
                break;
                case '3':
                    // TO-BE-DONE
                break;
                 case '4':
                    // TO-BE-DONE
                break;
                case '0':
                    salir = true;
                }
            } while (!salir);
    }
}
    

