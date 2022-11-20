package POOandCo.dao;

import POOandCo.modelo.Cliente;

import java.util.List;

public interface DaoCliente<T> {   
    public List<T> listarSTD() throws Exception;
    public List<T> listarPRM() throws Exception;
    public boolean registrar(T t) throws Exception;   
   // public Cliente getClientes(String e_Mail, float c_alculo, float d_escuento);
}