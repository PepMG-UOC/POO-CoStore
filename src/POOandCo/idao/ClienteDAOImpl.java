package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAOImpl implements DAO<Cliente> {

    @Override
    public List<Cliente> listar() throws Exception {
        return null;
    }

    @Override
    public List<Cliente> listarSTD() throws Exception {
        List<Cliente> lista = new ArrayList<>();        
        Cliente cliente;
        Connection con=null;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientesEstandard}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){                
                //cliente = new Cliente(rs.getString("id_eMail"),rs.getString("Nombre"),rs.getString("Domicilio"),rs.getString("Nif"));
                cliente = new ClienteEstandard(rs.getString("id_eMail"), rs.getString("Nombre"),rs.getString("Domicilio"), rs.getString("Nif"));
                lista.add(cliente);                
            }
            rs.close();
        }catch (Exception e){
            return null;
        }
        return lista;
    }

    @Override 
    public List<Cliente> listarPRM() throws Exception {
        List<Cliente> lista = new ArrayList<>();        
        Cliente cliente;
        Connection con=null;
        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientesPremium}");
            ResultSet rs = sp.executeQuery();
            while(rs.next()){                
                cliente = new ClientePremium(rs.getString("id_eMail"), rs.getString("Nombre"),rs.getString("Domicilio"), rs.getString("Nif"));
                lista.add(cliente);                
            }
            rs.close();
        }catch (Exception e){
            return null;
        }
        return lista;        
    }


    /* @Override
    public void mostrar(Cliente cliente) throws Exception {

        /*
        Connection con=null;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientes}");
            ResultSet rs = sp.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
            rs.close();

        }catch (Exception e){

        }

         

    } */

   /*  @Override
    public void clientesDAO() {

        Connection con=null;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientes}");
            ResultSet rs = sp.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("id_eMail")+ " "+(rs.getString("Nombre")));
            }
            rs.close();

        }catch (Exception e){

        }

    } */

    @Override
    public void clientesDAOEst() {
        Connection con=null;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientesEstandard}");
            ResultSet rs = sp.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("id_eMailestandard"));
            }
            rs.close();

        }catch (Exception e){

        }
    }

    @Override
    public void clientesDAOPre() {
        Connection con=null;

        try{
            con= Conexion.conectar();
            CallableStatement sp= con.prepareCall("{CALL mostrarClientesPremium}");
            ResultSet rs = sp.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("id_eMailPremium"));
            }
            rs.close();

        }catch (Exception e){

        }
    }


    @Override
    public boolean registrar(Cliente cliente) throws Exception {        
        Connection con=null;
        boolean altaCliente=false;

        try {
            con= Conexion.conectar();

            CallableStatement sp= con.prepareCall("CALL añadirCliente(?,?,?,?,?)");
            sp.setString("eMail_Cliente", cliente.geteMail());
            sp.setString("Nombre_Cliente",cliente.getNombre());
            sp.setString("Domicilio_Cliente", cliente.getDomicilio());
            sp.setString("Nif_Cliente",cliente.getNif());
            sp.registerOutParameter("guardado", Types.BOOLEAN);
            sp.execute();
            if (sp.getBoolean("guardado")==true)
            {
                altaCliente=true;
            } else  altaCliente=false;
            sp.close();

            if(altaCliente){
                if(cliente instanceof ClienteEstandard){
                    sp= con.prepareCall("CALL adClienteSTD(?,?,?,?)");
                    sp.setString("eMail_Cliente", cliente.geteMail());
                    sp.setFloat("Descuento_Cliente",cliente.descuentoEnv());
                    sp.setFloat("Tarifa_Cliente",cliente.calcAnual());
                    sp.registerOutParameter("guardado", Types.BOOLEAN);
                    sp.execute();
                    if (sp.getBoolean("guardado")==true)
                    {
                        altaCliente=true;
                    } else  altaCliente=false;
                    sp.close();
                } else {
                    sp= con.prepareCall("CALL adClientePRM(?,?,?,?)");
                    sp.setString("eMail_Cliente", cliente.geteMail());
                    sp.setFloat("Descuento_Cliente",cliente.descuentoEnv());
                    sp.setFloat("Tarifa_Cliente",cliente.calcAnual());
                    sp.registerOutParameter("guardado", Types.BOOLEAN);
                    sp.execute();
                    if (sp.getBoolean("guardado")==true)
                    {
                        altaCliente=true;
                    } else  altaCliente=false;
                    sp.close();
                }
            }
            con.close();            
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDAOImpl, método AñadirCliente");
            e.printStackTrace();
        }

        return altaCliente;
    }
    
    @Override
    public int getNumPedido(){
        return 0;
    }
    
    @Override
    public void modificar(Cliente cliente) throws Exception {

    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {

    }

    @Override
    public Articulo getArticuloDAOById(String idArticulo) {
        return null;
    }


}
