
package POOandCo.modelo;

import java.util.ArrayList;

//prueba
public class ListaPedidos extends Lista<Pedido>{


    //he quitado este metodo y lo he añadido en la clase generica Lista.

    /*
    public ArrayList<Pedido> getLista() {
        return lista;
    }

     */

    public void setLista(ArrayList<Pedido> lista) {
        this.lista = lista;
    }
    
}
