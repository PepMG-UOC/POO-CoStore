package POOandCo.dao;

import POOandCo.modelo.ListaPedidos;

import java.util.List;

public interface DaoPedido<T> {


    public boolean registrar(T t) throws Exception;
    public int getNumPedido();
    public boolean existePedido(int id_Pedido);
    public void borrarPedido(int id_Pedido);
    public List<T> listarTodosPedidos() throws Exception;
    public ListaPedidos listarToPedidos() throws Exception;


}
