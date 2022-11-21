package POOandCo.idao;

import POOandCo.dao.*;
import POOandCo.modelo.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAOImpl implements DaoCliente<Cliente> {

    
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
            e.printStackTrace();
        }

        return altaCliente;
    }
    


}
