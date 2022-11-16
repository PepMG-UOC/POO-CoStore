package POOandCo.idao;

import POOandCo.dao.Conexion;
import POOandCo.dao.DAO;
import POOandCo.modelo.*;

import java.util.List;

public class PedidoDAOImpl implements DAO<Pedido> {


    @Override
    public List<Pedido> listar() throws Exception {
        return null;
    }

    @Override
    public void mostrar(Pedido pedido) throws Exception {

    }

    @Override
    public boolean registrar(Pedido pedido) throws Exception {
        return false;
    }
    
    @Override
    public void modificar(Pedido pedido) throws Exception {

    }

    @Override
    public void eliminar(Pedido pedido) throws Exception {

    }

    @Override
    public Articulo getArticuloDAOById(String idArticulo) {
        return null;
    }
}
