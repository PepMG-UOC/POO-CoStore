package POOandCo.dao;
//import interfaces.DAOpersona;

import POOandCo.modelo.Persona;
import POOandCo.vista.DAOpersona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOpersonaImpl extends Conexion implements DAOpersona {

    @Override
    public void registrar(Persona per) throws Exception {
        try{
            this.conectar();
            PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO Persona(nombre) VALUES(?)");
            st.setString(1, per.getNombre());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Persona per) throws Exception {
        try{
            this.conectar();
            PreparedStatement st = this.miConexion.prepareStatement("delete from Persona where id = ?");
            st.setString(1, per.getNombre());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista = null;
        try{
            this.conectar();
            PreparedStatement st = this.miConexion.prepareStatement("select * drom persona");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setCodigo(rs.getInt("id"));
                lista.add(per);
            }
            rs.close();
            st.close();
        }catch (Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }







}
