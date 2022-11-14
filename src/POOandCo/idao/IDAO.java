package POOandCo.idao;

import POOandCo.modelo.Articulo;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    //public boolean añadirArticulo2(Articulo articulo);
    public void mostrarArticulo2();

    List<T> listar() throws Exception;

    public void mostrar(T t) throws Exception;
    public boolean registrar(T t) throws Exception;
    public void modificar(T t) throws Exception;
    public void eliminar(T t) throws Exception;


}
