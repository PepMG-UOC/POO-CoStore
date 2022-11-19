package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DaoPedido;
import POOandCo.modelo.*;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;

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

    private Articulo devuelvoArticulo (String idArticulo, Connection con)
    {
        //Tengo los datos y ahora tengo que saber que articulo es y que cliente
        //Primero Articulo. Utilizaré el mostrar artículo.
        Articulo art;
        try
        {
            CallableStatement spArticulo=con.prepareCall("CALL mostrarArticulo(?,?,?,?,?,?)");
            spArticulo.setString("id_Articulo",idArticulo);
            spArticulo.registerOutParameter("Descripcion_Articulo", Types.VARCHAR);
            spArticulo.registerOutParameter("PvpVenta_Articulo",Types.FLOAT);
            spArticulo.registerOutParameter("GastosEnvio_Articulo",Types.FLOAT);
            spArticulo.registerOutParameter("TiempoPreparacion_Articulo", Types.INTEGER);
            spArticulo.registerOutParameter("encontrado", Types.BOOLEAN);
            spArticulo.execute();
            if (spArticulo.getBoolean("encontrado")==false)
            {
                art=null;
            }
            else
            {
                art=new Articulo(idArticulo,spArticulo.getString("Descripcion_Articulo"),
                        spArticulo.getFloat("PvpVenta_Articulo"), spArticulo.getFloat("GastosEnvio_Articulo"),
                        spArticulo.getInt("TiempoPreparacion_Articulo"));
            }
            spArticulo.close();
        }
        catch (SQLException e) {
            System.out.println("Error: Clase ArticuloDaoImpl, método getArticuloDAOById2");
            e.printStackTrace();
            return null;
        }
        return art;
    }
    private ClientePremium devuelvoClientePremium(String id_cliente, Connection con)
    {
        ClientePremium cliPre=null;
        try
        {
            CallableStatement spClientePremium=con.prepareCall("CALL devolverClientePremium(?)");
            spClientePremium.setString("id_Email",id_cliente);
            ResultSet rs=spClientePremium.executeQuery();
            while(rs.next()){
                cliPre=new ClientePremium(rs.getString("id_Email"),rs.getString("Nombre"),
                        rs.getString("Domicilio"), rs.getString("Nif"));
                cliPre.setDescuento(rs.getFloat("Descuento"));
                cliPre.setCalculo(rs.getFloat("TarifaAnual"));
            }
        }
        catch (Exception e){
            return null;
        }
        return cliPre;
    }

    private ClienteEstandard devuelvoClienteEstandard(String id_cliente, Connection con)
    {
        ClienteEstandard cli=null;
        try {
            CallableStatement spClienteEstandard=con.prepareCall("CALL devolverClienteEstandard(?)");
            spClienteEstandard.setString("id_Email",id_cliente);
            ResultSet rs=spClienteEstandard.executeQuery();
            while(rs.next()){
                cli = new ClienteEstandard(rs.getString("id_Email"), rs.getString("Nombre"),rs.getString("Domicilio"),
                        rs.getString("Nif"));
            }
        }
        catch (Exception e){
            return null;
        }
        return cli;
    }

    @Override
    public ArrayList<Pedido> listarTodosPedidos() throws Exception {
        ArrayList<Pedido> lista = new ArrayList<>();
        Pedido pedido;

        Connection con=null;
        int id_Pedido;
        int cantidad_Pedido;
        Timestamp fechaHora_Pedido;
        String id_Articulo_Pedido;
        String id_eMail_Pedido;
        boolean esClienteEstandard= false;
        ClienteEstandard clienteEstandard;
        ClientePremium clientePremium;
        Articulo art;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL devolverTodosPedidos}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){
                //Voy a leer lo que devuelva para identificar el articulo y el cliente
                id_Pedido=rs.getInt("idPedido");
                cantidad_Pedido=rs.getInt("Cantidad");
                fechaHora_Pedido=rs.getTimestamp("FechaHora");
                id_Articulo_Pedido=rs.getString("idArticuloPedido");
                id_eMail_Pedido=rs.getString("id_eMailPedido");

                art=devuelvoArticulo(id_Articulo_Pedido,con);
                //Ahora tengo que saber el cliente
                clienteEstandard=devuelvoClienteEstandard(id_eMail_Pedido,con);
                if (clienteEstandard!=null)
                {
                    pedido=new Pedido(id_Pedido,art,cantidad_Pedido,clienteEstandard);
                    pedido.setFechaYhora(fechaHora_Pedido.toLocalDateTime());
                } else
                {
                    clientePremium=devuelvoClientePremium(id_eMail_Pedido,con);
                    if (clientePremium!=null)
                    {
                        pedido=new Pedido(id_Pedido,art,cantidad_Pedido,clientePremium);
                        pedido.setFechaYhora((fechaHora_Pedido.toLocalDateTime()));
                    } else pedido=null;
                }
                lista.add(pedido);
            }
            rs.close();
        }catch (Exception e){
            return null;
        }
        return lista;
    }

    @Override
    public ListaPedidos listarToPedidos() throws Exception {
        ListaPedidos lista= new ListaPedidos();
        //ArrayList<Pedido> lista = new ArrayList<>();
        Pedido pedido;

        Connection con=null;
        int id_Pedido;
        int cantidad_Pedido;
        Timestamp fechaHora_Pedido;
        String id_Articulo_Pedido;
        String id_eMail_Pedido;
        boolean esClienteEstandard= false;
        ClienteEstandard clienteEstandard;
        ClientePremium clientePremium;
        Articulo art;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL devolverTodosPedidos}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){
                //Voy a leer lo que devuelva para identificar el articulo y el cliente
                id_Pedido=rs.getInt("idPedido");
                cantidad_Pedido=rs.getInt("Cantidad");
                fechaHora_Pedido=rs.getTimestamp("FechaHora");
                id_Articulo_Pedido=rs.getString("idArticuloPedido");
                id_eMail_Pedido=rs.getString("id_eMailPedido");

                art=devuelvoArticulo(id_Articulo_Pedido,con);
                //Ahora tengo que saber el cliente
                clienteEstandard=devuelvoClienteEstandard(id_eMail_Pedido,con);
                if (clienteEstandard!=null)
                {
                    pedido=new Pedido(id_Pedido,art,cantidad_Pedido,clienteEstandard);
                    pedido.setFechaYhora(fechaHora_Pedido.toLocalDateTime());
                } else {
                    clientePremium=devuelvoClientePremium(id_eMail_Pedido,con );
                    pedido=new Pedido(id_Pedido,art,cantidad_Pedido,clientePremium);
                    pedido.setFechaYhora(fechaHora_Pedido.toLocalDateTime());
                }
                lista.add(pedido);
            }
            rs.close();
        }catch (Exception e){
            return null;
        }
        return lista;

    }

}
