package POOandCo.dao;

import POOandCo.modelo.Articulo;

public interface DaoArticulo<T> {
    public boolean registrar(T t) throws Exception;
    public Articulo getArticuloDAOById(String idArticulo);

}