/*
 * Aplicación de escritorio basada en Java que se ejecutará en el backend 
 * como alternativa a la aplicación web de un comercio electronico.
 * 
 */
package POOandCo.vista;


import POOandCo.dao.Conexion;
import POOandCo.idao.ClienteDAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class OnlineStore {

    public static void main(String[] args) {

        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }




}
