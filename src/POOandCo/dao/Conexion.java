package POOandCo.dao;
import java.sql.*;


public class Conexion {


    protected Connection miConexion;
    private final String urlBD = "jdbc:mysql://localhost:3306/productotres";
    private final String user = "root";
    private final String pass = "";


    //Para conectar a la BD
    public void conectar(){
        try{
            Connection miConexion= DriverManager.getConnection(urlBD, user, pass);
        }catch(Exception e){
            System.out.println("no conecta");
            e.printStackTrace();
        }
    }


    //para cerrar la conexion
    public void cerrar() throws SQLException{
        if(miConexion != null){
            if(!miConexion.isClosed()){
                miConexion.close();
            }
        }
    }





    /*
    Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/productotres", "root", "Perryman43");

    //CREAR OBJETO STATEMENT
    Statement miStatement = miConexion.createStatement();

    //EJECUTAR SQL
    ResultSet miResulset = miStatement.executeQuery("SELECT * FROM ARTICULOS");

    //RECORRER EL RESULSET y mostrar los datos de la tabla

            while (miResulset.next()){

        System.out.println(miResulset.getString("CODIGOARTICULO") + " " + miResulset.getString("NOMBREARTICULO"));

    }

     */
}
