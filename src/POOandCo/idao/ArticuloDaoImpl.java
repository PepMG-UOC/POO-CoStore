package POOandCo.idao;
import java.sql.*;
import java.util.List;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.Articulo;


public class ArticuloDaoImpl implements DAO<Articulo> {


    @Override
    public boolean registrar(Articulo articulo) throws SQLException {
        Statement stm= null;
        Connection con=null;
        boolean altaArticulo=false;

        String sql="INSERT INTO articulo values ('"+articulo.getCodigo()+
                "','"+articulo.getDescripcion()+"','"+articulo.getPvpVenta()+
                "','"+ articulo.getGastosEnvio()+"','"+ articulo.getTiempoPreparacion()+"')";
        try {
            con= Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);

            stm.close();
            con.close();
            altaArticulo=true;

        } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método AñadirArticulo2");
            e.printStackTrace();
        }

        return altaArticulo;
    }



    @Override
    public void mostrar(Articulo articulo) throws Exception {

        Statement stm= null;
        Connection con=null;
        con = Conexion.conectar();

        ResultSet resultSet = stm.executeQuery("SELECT * FROM articulo");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
        stm.close();
        con.close();

    }



    /*
    @Override
    public void mostrarArticulo2() {

    }
     */

    @Override
    public List<Articulo> listar() throws Exception {
        return null;
    }

    @Override
    public void modificar(Articulo articulo) throws Exception {

    }

    @Override
    public void eliminar(Articulo articulo) throws Exception {

    }
}
