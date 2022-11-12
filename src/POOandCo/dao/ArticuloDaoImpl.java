package POOandCo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POOandCo.dao.Conexion;
import POOandCo.idao.IclienteDao;
import POOandCo.modelo.Articulo;


public class ArticuloDaoImpl implements IclienteDao{


    @Override
    public boolean añadirArticulo2(Articulo articulo) {
        Statement stm= null;
        Connection con=null;
        boolean altaArticulo=false;

        String sql="INSERT INTO articulo values ('"+articulo.getCodigo()+
                "','"+articulo.getDescripcion()+"','"+articulo.getPvpVenta()+
                "','"+ articulo.getGastosEnvio()+"','"+ articulo.getTiempoPreparacion()+"')";
        try {
            con=Conexion2.conectar();
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
    public void mostrarArticulo2() {

    }
}
