package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.Articulo;
import POOandCo.modelo.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClienteDAOImpl implements DAO<Cliente> {

    @Override
    public List<Cliente> listar() throws Exception {
        return null;
    }

    @Override
    public void mostrar(Cliente cliente) throws Exception {

    }

    @Override
    public boolean registrar(Cliente cliente) throws Exception {
        Statement stm= null;
        Connection con=null;
        boolean altaCliente=false;

        String sql="INSERT INTO cliente values ('"+cliente.geteMail()+
                "','"+cliente.getNombre()+"','"+cliente.getDomicilio()+
                "','"+cliente.getNif()+"')";
        try {
            con= Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);

            stm.close();
            con.close();
            altaCliente=true;

        } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método AñadirArticulo2");
            e.printStackTrace();
        }

        return altaCliente;
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {

    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {

    }
}
