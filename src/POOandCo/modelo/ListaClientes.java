
package POOandCo.modelo;

import java.util.ArrayList;


public class ListaClientes extends Lista<Cliente>{


    //he quitado este metodo y lo he añadido en la clase generica Lista.
    /*
    public ArrayList<Cliente> getLista() {
        return lista;
    }

     */

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }
    
}
