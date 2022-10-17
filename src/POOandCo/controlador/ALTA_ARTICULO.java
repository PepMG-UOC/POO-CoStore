/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POOandCo.controlador;

import POOandCo.modelo.Articulo;
import POOandCo.vista.FormArticulo;


public class ALTA_ARTICULO {
    String codigo;
    String descripcion;
    double pvpVenta;
    double gastosEnvio;
    int tiempoPreparacion;
    Articulo setArticulo;
    FormArticulo getArticulo;
    
    
    public void ObtenDatosPedidos(){
        codigo = getArticulo.getjTextField1().getText();
        descripcion = getArticulo.getjTextField2().getText();
        pvpVenta = Double.parseDouble(getArticulo.getjTextField3().getText()) ;
        gastosEnvio = Double.parseDouble(getArticulo.getjTextField4().getText());
        tiempoPreparacion = Integer.parseInt(getArticulo.getjTextField5().getText());
    }
    
    public void GrabarDatosPedido(){
        setArticulo = new Articulo(codigo, descripcion, pvpVenta, gastosEnvio, tiempoPreparacion);
    }
}
