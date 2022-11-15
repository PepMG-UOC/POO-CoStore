package POOandCo.idao;

import POOandCo.dao.DAO;
import POOandCo.dao.DAOpedido;
import POOandCo.modelo.Cliente;
import POOandCo.modelo.Pedido;

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
    public boolean registrar1(Cliente cliente) throws Exception {
        return false;
    }

    @Override
    public boolean registrar2(Cliente cliente) throws Exception {
        return false;
    }

    @Override
    public void modificar(Pedido pedido) throws Exception {

    }

    @Override
    public void eliminar(Pedido pedido) throws Exception {

    }
}
