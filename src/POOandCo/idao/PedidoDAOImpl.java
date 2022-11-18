package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.dao.DaoPedido;
import POOandCo.modelo.*;

import java.sql.*;
import java.util.List;
import java.time.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class PedidoDAOImpl implements DaoPedido<Pedido> {

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
    public boolean existePedido(int id_Pedido) {
        Connection con=null;
        boolean existe=false;
        try {
            con=Conexion.conectar();
            CallableStatement sp=con.prepareCall("CALL existePedido(?,?)");
            sp.setInt("id_Pedido",id_Pedido);
            sp.registerOutParameter("encontrado", Types.BOOLEAN);
            sp.execute();
            existe= sp.getBoolean("encontrado");
            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PedidoDaoImpl, método existePedido");
        }
        return existe;
    }

    @Override
    public void borrarPedido(int id_Pedido) {
        Connection con=null;
        boolean existe=false;
        try {
            con=Conexion.conectar();
            CallableStatement sp=con.prepareCall("CALL eliminarPedido(?)");
            sp.setInt("id_Pedido",id_Pedido);
            sp.execute();
            sp.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PedidoDaoImpl, método borrarPedido");
        }

    }

    @Override
    public List<Pedido> listarTodosPedidos() throws Exception {
       /* List<Pedido> lista = new ArrayList<>();
        Pedido pedido;
        Connection con=null;
        ClienteEstandard clienteEstandard;
        ClientePremium clientePremium;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL devolverTodosPedidos}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){



                //cliente = new Cliente(rs.getString("id_eMail"),rs.getString("Nombre"),rs.getString("Domicilio"),rs.getString("Nif"));
                //cliente = new ClienteEstandard(rs.getString("id_eMail"), rs.getString("Nombre"),rs.getString("Domicilio"), rs.getString("Nif"));
                //lista.add(cliente);
            }
            rs.close();
        }catch (Exception e){
            return null;
        }
        return lista;
        */

        return null;
    }

}
