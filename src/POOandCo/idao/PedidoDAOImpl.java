package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.*;

import java.sql.*;
import java.util.List;
import java.time.*;
import java.util.ArrayList;

public class PedidoDAOImpl implements DAO<Pedido> {


    @Override
    public List<Pedido> listar() throws Exception {
        return null;
    }

    @Override
    public List<Pedido> listarSTD() throws Exception {
        return null;
    }

    @Override
    public List<Pedido> listarPRM() throws Exception {
        return null;
    }

    /* @Override
    public void mostrar(Pedido pedido) throws Exception {

    } */

    //https://stackoverflow.com/questions/39836994/how-to-insert-datetime-field-in-mysql-database-using-preparedstatement-in-java
    //https://www.tutorialspoint.com/how-to-insert-current-date-and-time-in-a-database-using-jdbc
    //CURRENT_TIMESTAMP
    @Override
    public boolean registrar(Pedido pedido) throws Exception {
        //Statement stm= null;
        Connection con=null;
        boolean altaPedido=false;
        LocalDateTime localDateTime;
        Timestamp timestamp;

        try {
            con=Conexion.conectar();
            CallableStatement sp= con.prepareCall("CALL añadirPedido(?,?,?,?,?)");
            sp.setInt("Cantidad_ArticuloPedido",pedido.getCantidad());
            localDateTime=pedido.getFechaYhora();
            timestamp = Timestamp.valueOf(localDateTime);
            sp.setTimestamp("FechaHora_Pedido",timestamp);            
            sp.setString("id_ArticuloPedido",pedido.getArticulo().getCodigo());
            sp.setString("id_eMailClientePedido",pedido.getCliente().geteMail());
            sp.registerOutParameter("guardado", Types.BOOLEAN);
            sp.execute();
            
            if (sp.getBoolean("guardado")==true)
            {
                altaPedido=true;
            } else  altaPedido=false;             

            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Pedido");
            e.printStackTrace();
        }
        return altaPedido;

    }
    
    @Override
    public int getNumPedido(){
        int numPedido=0;
        Connection con=null;
        try {
            con=Conexion.conectar();
            CallableStatement sp= con.prepareCall("CALL getNumPedido(?)");
            sp.registerOutParameter("numPedido", Types.INTEGER);
            sp.execute();
            numPedido = sp.getInt("numPedido");
            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método AñadirArticulo2");
            e.printStackTrace();
        }
        return numPedido;
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

    /* @Override
    public void clientesDAO() {

    } */

    @Override
    public void clientesDAOEst() {

    }

    @Override
    public void clientesDAOPre() {

    }
}
