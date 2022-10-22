
package POOandCo.controlador;

import java.util.List;
import POOandCo.modelo.Datos;
import POOandCo.vista.*;
import java.util.ArrayList;

public class Controlador {
    private Datos datos;
   // private List<ArrayList> lista;
    
    public Controlador() {
        datos = new Datos ();
    }
/*
    public Controlador(Datos datos) {
        this.datos = datos;
    } */
    
    
// TO-BE-DON

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {        
        this.datos = datos;
    }

    

}
