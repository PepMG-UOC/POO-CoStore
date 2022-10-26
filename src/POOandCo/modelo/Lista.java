
package POOandCo.modelo;

import java.util.ArrayList;


public class Lista<T> {
    protected ArrayList<T> lista;
    
    public Lista() {
        lista = new ArrayList<>();
    }
    
    public int getSize() {        
        return lista.size();
    }
    
    public void add(T t) {
        lista.add(t);
        
    }
   
    
    public void borrar(T t) {
        for (int i=0; i<lista.size(); i++){
            if(t.equals(lista.get(i))) {
                lista.remove(i);
                break;
            }
        }
    }
    
    public T getAt(int position) {    
       return  lista.get(position);      
    }
    
    public void clear() {
        
    }
    public boolean isEmpty() {
    // TO-BE-DONE
        return true;
    }
    
    public ArrayList<T> getLista() {

        return lista;
    }
}
