package POOandCo.dao;
import java.sql.*;

public class Conexion {

    public static Connection conectar() {
        Connection con = null;

        String password = "poobd123";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/poobbdd?user=" + usuario
                + "&password=" + password;
        try {
            con = DriverManager.getConnection(url);          
            } catch (SQLException e) {          
            e.printStackTrace();
            }
        return con;
    }
}
