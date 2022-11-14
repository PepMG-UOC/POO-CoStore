package POOandCo.idao;

import POOandCo.modelo.Articulo;

public interface IDatosDao {
    public boolean añadirArticulo2(Articulo articulo);
    public Articulo mostrarArticulo2(String idArticulo);
}
