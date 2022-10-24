
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
            System.out.println(); 
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
                    showClientes();
                break;
                case '3':
                    showClientesPorTipo("Estandard");
                break;
                 case '4':
                    showClientesPorTipo("Premium");
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
    
    public void addCliente() {       
        System.out.println(); 
        System.out.println("===== Introducir Cliente =====");
        System.out.println(); 
        System.out.print("eMail: ");
        eMail = teclado.nextLine();
        if (controlador.clienteByEmail(eMail)!=-1){    
             System.out.print("El cliente con eMail: " + eMail + " ya existe.");
             System.out.println();
        } 
        else {
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Domicilio: ");
        domicilio = teclado.nextLine();
        System.out.print("NIF: ");
        nif = teclado.nextLine();
        System.out.print("(1)Estandard / (2)Premium");
        tipo = teclado.nextLine();
        controlador.getDatos().setCliente(eMail, nombre, domicilio, nif, tipo);
        }         
    }
    
    public void showClientes(){
        System.out.println();
        System.out.println("===== Mostrar TODOS LOS Clientes =====");
        System.out.println();
        System.out.print( controlador.getDatos().getListaClientes().getLista().toString());
        System.out.println();
    }
    
    private void showClientesPorTipo(String tipo){
        System.out.println();
        System.out.println("===== Mostrar clientes estandar =====");
        System.out.println();   
        for(int item=0; item<(controlador.getDatos().getListaClientes().getLista().size()); item++) {
            if (tipo.equals(controlador.getDatos().getListaClientes().getLista().get(item).tipoCliente())){
                System.out.print(controlador.getDatos().getListaClientes().getLista().get(item));
            }
        }
        System.out.println();         
    }
    
    
    
}
