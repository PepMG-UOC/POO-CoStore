package POOandCo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import POOandCo.dao.Conexion;
import POOandCo.idao.IDatosDao;
import POOandCo.modelo.Articulo;
import com.mysql.cj.xdevapi.Type;


public class ArticuloDaoImpl implements IDatosDao{


    @Override
    public boolean añadirArticulo2(Articulo articulo) {
        Statement stm= null;
        Connection con=null;
        boolean altaArticulo=false;

       /* String sql="INSERT INTO articulo values ('"+articulo.getCodigo()+
                "','"+articulo.getDescripcion()+"','"+articulo.getPvpVenta()+
                "','"+ articulo.getGastosEnvio()+"','"+ articulo.getTiempoPreparacion()+"')";*/
        try {
            con=Conexion2.conectar();
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


    @Override
    public Articulo mostrarArticulo2(String id) {

        Statement stm= null;
        Connection con=null;
        boolean encontradoArticulo=false;
        Articulo art;
        try {
            con=Conexion2.conectar();
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
