
package POOandCo.vista;

import java.util.Scanner;
import POOandCo.controlador.Controlador;

public class MenuArticulo {
    Scanner teclado = new Scanner(System.in);

    /*public MenuArticulo(Controlador controlador) {
         controlador.datos.listaArticulos.lista.add(new Articulo(codigo,descripcion,pvpVenta,gastosEnvio,tiempoPreparacion));
    }*/
    
    public void menu() {
       boolean salir = false;
        char opcio;
        do {
            System.out.println(); 
            System.out.println("1. Añadir Articulo");
            System.out.println("2. Mostrar Articulo");            
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                 addArticulo();
                  
                break;
                case '2':
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

    private void addArticulo() {
        String codigo;
        String descripcion;
        float pvpVenta;
        float gastosEnvio;
        int tiempoPreparacion;
                  
        System.out.println("===== Introducir Artículo =====");
        System.out.println(); 
        System.out.print("Codigo: ");
        codigo = teclado.nextLine();
        System.out.print("Descripcion: ");  
        descripcion = teclado.nextLine();
        System.out.print("Pvp de venta: ");
        pvpVenta = Float.valueOf(teclado.nextLine());
        System.out.print("Gastos de envio: ");
        gastosEnvio = Float.valueOf(teclado.nextLine());
        System.out.print("Tiempo preparacion (min): ");
        tiempoPreparacion = Integer.valueOf(teclado.nextLine());
         
      //  controlador.setDatos();
      //   controlador.datos.articulo(codigo,descripcion,pvpVenta,gastosEnvio,tiempoPreparacion);
      //  controlador.datos.listaArticulos.lista.add(Articulo(codigo,descripcion,pvpVenta,gastosEnvio,tiempoPreparacion));
 
            
       
    }
}
