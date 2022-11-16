package POOandCo.idao;
import java.sql.*;
import java.util.List;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.Articulo;
import POOandCo.modelo.Cliente;


public class ArticuloDaoImpl implements DAO<Articulo> {


    //Claudia
    @Override
    public boolean registrar(Articulo articulo) throws SQLException {
        Statement stm= null;
        Connection con=null;
        boolean altaArticulo=false;

       /* String sql="INSERT INTO articulo values ('"+articulo.getCodigo()+
                "','"+articulo.getDescripcion()+"','"+articulo.getPvpVenta()+
                "','"+ articulo.getGastosEnvio()+"','"+ articulo.getTiempoPreparacion()+"')";*/
        try {
            con=Conexion.conectar();
            CallableStatement sp= con.prepareCall("CALL añadirArticulo(?,?,?,?,?,?)");
            sp.setString("id_Articulo", articulo.getCodigo());
            sp.setString("Descripcion_Articulo",articulo.getDescripcion());
            sp.setFloat("PvpVenta_Articulo", articulo.getPvpVenta());
            sp.setFloat("GastosEnvio_Articulo",articulo.getGastosEnvio());
            sp.setInt("TiempoPreparacion_Articulo",articulo.getTiempoPreparacion());
            sp.registerOutParameter("guardado", Types.BOOLEAN);
            sp.execute();

            if (sp.getBoolean("guardado")==true)
            {
                altaArticulo=true;
            } else  altaArticulo=false;

            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método AñadirArticulo2");
            e.printStackTrace();
        }
        return altaArticulo;

    }



    /*
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

     */

    @Override
    public boolean registrar1(Cliente cliente) throws Exception {
        return false;
    }

    @Override
    public boolean registrar2(Cliente cliente) throws Exception {
        return false;
    }




/*
    @Override
    public void mostrar(Articulo articulo) throws Exception {

        Connection con=null;
        Statement stmt = con.createStatement();
        ResultSet rs;



        try {
            rs = stmt.executeQuery("SELECT * FROM articulo WHERE codigo="+codigo);
            while ( rs.next() ) {
                String lastName = rs.getString("codigo");
                System.out.println(lastName);
            }

            } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método mostrar");
            e.printStackTrace();
        }


        Statement stm= null;
        Connection con=null;
        con = Conexion.conectar();


        ResultSet resultSet = stm.executeQuery("SELECT * FROM articulo");

        ResultSetMetaData rsmd = resultSet.getMetaData();


        int columnsNumber = rsmd.getColumnCount();

        try {
            con= Conexion.conectar();
            stm= con.createStatement();
            stm.execute();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        }catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método mostrar");
            e.printStackTrace();
        }

        stm.close();
        con.close();



    }

*/




    @Override
    public List<Articulo> listar() throws Exception {
        return null;
    }

    @Override
    public void mostrar(Articulo articulo) throws Exception {

    }

    @Override
    public void modificar(Articulo articulo) throws Exception {

    }

    @Override
    public void eliminar(Articulo articulo) throws Exception {

    }

    //Claudia
    @Override
    public Articulo mostrarArticulo2(String id) {
        Statement stm= null;
        Connection con=null;
        boolean encontradoArticulo=false;
        Articulo art;
        try {
            con=Conexion.conectar();
            CallableStatement sp= con.prepareCall("CALL mostrarArticulo(?,?,?,?,?,?)");
            sp.setString("id_Articulo",id);
            sp.registerOutParameter("Descripcion_Articulo", Types.VARCHAR);
            sp.registerOutParameter("PvpVenta_Articulo",Types.FLOAT);
            sp.registerOutParameter("GastosEnvio_Articulo",Types.FLOAT);
            sp.registerOutParameter("TiempoPreparacion_Articulo", Types.INTEGER);
            sp.registerOutParameter("encontrado", Types.BOOLEAN);
            sp.execute();

            if (sp.getBoolean("encontrado")==false)
            {
                art=null;
            }
            else
            {
                art=new Articulo(id,sp.getString("Descripcion_Articulo"), sp.getFloat("PvpVenta_Articulo"),
                        sp.getFloat("GastosEnvio_Articulo"), sp.getInt("TiempoPreparacion_Articulo"));
            }

            sp.close();
            con.close();
            return art;

        } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método mostrarArticulo2");
            e.printStackTrace();
            return null;
        }
    }
}
