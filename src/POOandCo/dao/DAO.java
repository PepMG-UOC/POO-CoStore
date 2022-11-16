package POOandCo.dao;

import POOandCo.modelo.Articulo;
import POOandCo.modelo.Cliente;

import java.util.List;

public interface DAO<T> {
    //public boolean añadirArticulo2(Articulo articulo);
    //public void mostrarArticulo2();

    List<T> listar() throws Exception;

    public void mostrar(T t) throws Exception;
    public boolean registrar(T t) throws Exception;
    public boolean registrar1(Cliente cliente) throws Exception;
    public boolean registrar2(Cliente cliente) throws Exception;
    public void modificar(T t) throws Exception;
    public void eliminar(T t) throws Exception;
    public Articulo mostrarArticulo2(String idArticulo);


}
