/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POOandCo.modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pep
 */
public class ArticuloTest {
    
    public ArticuloTest() {
    }
    
    Articulo instance = new Articulo("02D","Articulo Test",35.0F,10.0F,8);
    /**
     * Test of getCodigo method, of class Articulo.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");        
        String expResult = "02D";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        if(!expResult.equals(result)) {
            fail("No es el codigo esperado.");
        }
    }

    /**
     * Test of setCodigo method, of class Articulo.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "03E";
        instance = new Articulo(codigo,"Articulo Test",35.0F,10.0F,8);
        instance.setCodigo(codigo);        
    }

    /**
     * Test of getDescripcion method, of class Articulo.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");        
        String expResult = "Articulo Test";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        if(!expResult.equals(result)) {
            fail("No es la descripcion esperada.");
        }
    }

    /**
     * Test of setDescripcion method, of class Articulo.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "Nueva Descripcion";
        instance = new Articulo("20D",descripcion,35.0F,10.0F,8);
        instance.setDescripcion(descripcion);
    }

    /**
     * Test of getPvpVenta method, of class Articulo.
     */
    @Test
    public void testGetPvpVenta() {
        System.out.println("getPvpVenta");        
        float expResult = 35.0F;
        float result = instance.getPvpVenta();
        assertEquals(expResult, result, 0.0);
        
    }

}
