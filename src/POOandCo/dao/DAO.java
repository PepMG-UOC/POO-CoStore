package POOandCo.dao;

import POOandCo.modelo.Articulo;
import POOandCo.modelo.Cliente;

import java.util.List;

public interface DAO<T> {
    //public boolean añadirArticulo2(Articulo articulo);
    //public void getArticuloDAOById2();

    List<T> listar() throws Exception;

    public void mostrar(T t) throws Exception;
    public boolean registrar(T t) throws Exception;         
    public void modificar(T t) throws Exception;
    public void eliminar(T t) throws Exception;
    public Articulo getArticuloDAOById(String idArticulo);

    public void clientesDAO();
    public void clientesDAOEst();
    public void clientesDAOPre();


}
