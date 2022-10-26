package POOandCo.vista;

import java.util.Scanner;

public class ArticuloVista {
    Scanner teclado = new Scanner(System.in);

    public char menuPrincipal() {
        char opcion;
        
            System.out.println(); 
            System.out.println("1. Añadir Articulo");
            System.out.println("2. Mostrar Articulo");            
            System.out.println("0. Salir");
            opcion = pedirOpcion();
        return opcion;        
    }

    private char pedirOpcion() {
        String resp;
        System.out.print("Elige una opción (1,2 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    public void adCabecera(){
        System.out.println(); 
        System.out.println("===== Introducir Artículo =====");
        System.out.println();         
    }

    public void warning(String codigo, boolean exist){
        System.out.print("El articulo " + codigo);
        if (exist) System.out.print(" ya existe.");
        else System.out.print(" no existe");
        System.out.println(); 
    }


    public String codigoArticulo()
    {
        String codigo;
        System.out.print("Codigo del Arículo: ");
        codigo= teclado.nextLine();
        return codigo;
    }
    
    public String descripcionArticulo()
    {
        String descripcion;
        System.out.print("Descripcion: "); 
        descripcion= teclado.nextLine();
        return descripcion;
    }

    public float pvpVentaArticulo()
    {
        float pvp;
        System.out.print("Pvp de venta: ");
        pvp= teclado.nextFloat();
        teclado = new Scanner(System.in);
        return pvp;
    }

    public float gastosEnvioArticulo()
    {
        float gastosEnvio;
        System.out.print("Gastos de envio: ");
        gastosEnvio=teclado.nextFloat();
        teclado= new Scanner(System.in);
        return gastosEnvio;
    }

    public int tiempoPreparacionArticulo()
    {
        int tiempoPreparacion;
        System.out.print("Tiempo preparacion (min): ");
        tiempoPreparacion=teclado.nextInt();
        teclado= new Scanner(System.in);
        return tiempoPreparacion;
    }

    public void showCabecera(){
        System.out.println(); 
        System.out.println("===== Mostar Artículo =====");
        System.out.println();         
    }

    public void showArticulo(String articulo){
        System.out.println(articulo);
    }

    


}
