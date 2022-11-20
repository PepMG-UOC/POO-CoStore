package POOandCo.dao;

import java.util.List;

public interface DaoPedido<T> {

    public boolean registrar(T t) throws Exception;   
    public int getNumPedido();
    public boolean existePedido(int id_Pedido);
    public void borrarPedido(int id_Pedido);
    public List<String> listarPedidos() throws Exception;
    


}