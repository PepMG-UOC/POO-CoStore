
package POOandCo.vista;

import POOandCo.controlador.Controlador;

import java.util.Scanner;


public class GestionOS {
    private Controlador controlador;
    
    Scanner teclado = new Scanner(System.in);
    MenuArticulo articulos = new MenuArticulo();
    
    public GestionOS() {
        controlador = new Controlador();
    }
   
    public void inicio() {
       // controlador.setDatos(Lista<>);
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
                   articulos.menu();
                break;
                case '2':
                    menuClientes();
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


    private void menuClientes() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Estándar");
            System.out.println("4. Mostrar Clientes Premium");
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
    

