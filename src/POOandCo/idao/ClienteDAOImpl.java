package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.*;

import java.sql.*;
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
