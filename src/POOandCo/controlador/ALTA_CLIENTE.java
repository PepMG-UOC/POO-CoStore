/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POOandCo.controlador;

import POOandCo.modelo.Cliente;
import POOandCo.vista.FormCliente;

public class ALTA_CLIENTE {
    String eMail;
    String nombre;
    String domicilio;
    String nif;
    boolean esAbonado;
    Cliente setCliente;
    FormCliente getCliente;
    
    public void ObtenDatosCliente(){
        eMail = getCliente.getjTextField1().getText();
        nombre = getCliente.getjTextField2().getText();
        domicilio = getCliente.getjTextField3().getText();
        nif = getCliente.getjTextField4().getText();
    }
    
    public void GrabarDatosCliente(){
      //  setCliente = new Cliente(eMail, nombre, domicilio, nif);
    }
}
