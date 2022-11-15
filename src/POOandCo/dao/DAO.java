package POOandCo.dao;

import java.util.List;

public interface DAO<T> {
    //public boolean añadirArticulo2(Articulo articulo);
    //public void mostrarArticulo2();

    List<T> listar() throws Exception;

    public void mostrar(T t) throws Exception;
    public boolean registrar(T t) throws Exception;
    public void modificar(T t) throws Exception;
    public void eliminar(T t) throws Exception;


}
