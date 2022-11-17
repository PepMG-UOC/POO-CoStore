package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.time.LocalDateTime;

public class PedidoDAOImpl implements DAO<Pedido> {


    @Override
    public List<Pedido> listar() throws Exception {
        return null;
    }

    @Override
    public void mostrar(Pedido pedido) throws Exception {

    }


    //https://www.tutorialspoint.com/how-to-insert-current-date-and-time-in-a-database-using-jdbc
    //CURRENT_TIMESTAMP
    @Override
    public boolean registrar(Pedido pedido) throws Exception {
        //Statement stm= null;
        Connection con=null;
        boolean altaPedido=false;

        try {
            con=Conexion.conectar();
            CallableStatement sp= con.prepareCall("CALL añadirPedido(?,?,?)");
            //sp.setInt("id_Pedido", pedido.getNumPedido());
            sp.setInt("Cantidad",pedido.getCantidad());

            //sp.getTime("FechaHora", '2012-12-10 13:38:00.000');
            System.out.println("llegamos");
            sp.setString("id_ArticuloPedido",pedido.getArticuloPedido());
            sp.setString("id_eMailPedido",pedido.geteMailPedido());
            //sp.registerOutParameter("guardado", Types.BOOLEAN);
            sp.execute();

            /*
            if (sp.getBoolean("guardado")==true)
            {
                altaPedido=true;
            } else  altaPedido=false;

             */

            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Pedido");
            e.printStackTrace();
        }
        return altaPedido;

    }
    
    @Override
    public void modificar(Pedido pedido) throws Exception {

    }

    @Override
    public void eliminar(Pedido pedido) throws Exception {

    }

    @Override
    public Articulo getArticuloDAOById(String idArticulo) {
        return null;
    }

    @Override
    public void clientesDAO() {

    }

    @Override
    public void clientesDAOEst() {

    }

    @Override
    public void clientesDAOPre() {

    }
}
