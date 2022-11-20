package POOandCo.idao;

import POOandCo.dao.*;
import POOandCo.modelo.*;

import java.sql.*;
import java.util.List;
import java.time.*;
import java.util.ArrayList;

public class PedidoDAOImpl implements DaoPedido<Pedido> {


    @Override
    public boolean registrar(Pedido pedido) throws Exception {        
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
            e.printStackTrace();
        }
        return numPedido;
    }

    @Override
    public List<String> listarPedidos() throws Exception {
        List<String> lista = new ArrayList<>();        
        Connection con = null;
        try{ 
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL devolverTodosPedidos}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido(rs.getInt("idPedido"), null, rs.getInt("Cantidad"), null);
                pedido.setFechaYhora(rs.getTimestamp("FechaHora").toLocalDateTime());
                
                
                rs.getString("idArticuloPedido");
                rs.getString("id_eMailPedido");

            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return lista;
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
            e.printStackTrace();
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
            e.printStackTrace();
        }

    }



}
