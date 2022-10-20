
package POOandCo.controlador;

import java.util.List;
import POOandCo.modelo.Datos;

public class Controlador {
    private Datos datos;
    
    public Controlador() {
        datos = new Datos ();
    }
    
    
// TO-BE-DONE

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

}
