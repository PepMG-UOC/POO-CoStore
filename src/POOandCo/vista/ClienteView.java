
package POOandCo.vista;

import java.util.Scanner;
import POOandCo.controlador.Controlador;

public class ClienteView {
     Scanner teclado = new Scanner(System.in);
     static Controlador controlador;
     static String eMail;
     static String nombre;
     static String domicilio;
     static String nif;
     static String tipo;
     
     public ClienteView(Controlador controlador) {
        this.controlador = controlador;
    }
     
    
    public void menu() {
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
                   addCliente();
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
    
    char pedirOpcion() {
        String resp;
        System.out.print("Elige una opción (1,2,3 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
    
    private void addCliente() {
       
        System.out.println(); 
        System.out.println("===== Introducir Cliente =====");
        System.out.println(); 
        System.out.print("eMail: ");
        eMail = teclado.nextLine();
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Domicilio: ");
        domicilio = teclado.nextLine();
        System.out.print("NIF: ");
        nif = teclado.nextLine();
        System.out.print("(1)Estandard / (2)Premium");
        tipo = teclado.nextLine();
        
    }
}
