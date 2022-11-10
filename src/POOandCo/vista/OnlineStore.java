/*
 * Aplicación de escritorio basada en Java que se ejecutará en el backend 
 * como alternativa a la aplicación web de un comercio electronico.
 * 
 */
package POOandCo.vista;
import java.sql.*;


import java.sql.DriverManager;
import java.util.Scanner;


public class OnlineStore {

    public static void main(String[] args) {

        int lastid;

        try{
        //CREAR CONEXION
            Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/productotres", "root", "????");

            //CREAR OBJETO STATEMENT
            Statement miStatement = miConexion.createStatement();

            //EJECUTAR SQL
            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM ARTICULOS");

            //RECORRER EL RESULSET y mostrar los datos de la tabla

            while (miResulset.next()){

                System.out.println(miResulset.getString("CODIGOARTICULO") + " " + miResulset.getString("NOMBREARTICULO"));

            }

/*
            if (miResulset.next()){
                lastid = miResulset.getInt(1);
                lastid++;

            }else{

            }

 */

            //insertar valores en la tabla



            String sql = "INSERT INTO ARTICULOS(NOMBREARTICULO) VALUES ('Caja')";
            String sql2 = "INSERT INTO ARTICULOS(NOMBREARTICULO) VALUES ('Tuerca')";
            miStatement.executeUpdate(sql);
            miStatement.executeUpdate(sql2);



            //insertar articulo por pantalla


            Scanner teclado = new Scanner(System.in);
            String nombreArticulo;
            System.out.print("Nombre: ");
            nombreArticulo = teclado.nextLine();

            String sql3 = "INSERT INTO ARTICULOS(NOMBREARTICULO) VALUES ('"+nombreArticulo+"')";
            miStatement.executeUpdate(sql3);





        }catch(Exception e){

            System.out.println("no conecta");
            e.printStackTrace();
        }

        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }
    
}
