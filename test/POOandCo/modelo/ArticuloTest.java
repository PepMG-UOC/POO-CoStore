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
 * @author HP-OMEN
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
            fail("The test case is a prototype.");
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
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Articulo.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Articulo instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Articulo.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Articulo instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPvpVenta method, of class Articulo.
     */
    @Test
    public void testGetPvpVenta() {
        System.out.println("getPvpVenta");
        Articulo instance = null;
        float expResult = 0.0F;
        float result = instance.getPvpVenta();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPvpVenta method, of class Articulo.
     */
    @Test
    public void testSetPvpVenta() {
        System.out.println("setPvpVenta");
        float pvpVenta = 0.0F;
        Articulo instance = null;
        instance.setPvpVenta(pvpVenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGastosEnvio method, of class Articulo.
     */
    @Test
    public void testGetGastosEnvio() {
        System.out.println("getGastosEnvio");
        Articulo instance = null;
        float expResult = 0.0F;
        float result = instance.getGastosEnvio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGastosEnvio method, of class Articulo.
     */
    @Test
    public void testSetGastosEnvio() {
        System.out.println("setGastosEnvio");
        float gastosEnvio = 0.0F;
        Articulo instance = null;
        instance.setGastosEnvio(gastosEnvio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTiempoPreparacion method, of class Articulo.
     */
    @Test
    public void testGetTiempoPreparacion() {
        System.out.println("getTiempoPreparacion");
        Articulo instance = null;
        Integer expResult = null;
        Integer result = instance.getTiempoPreparacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTiempoPreparacion method, of class Articulo.
     */
    @Test
    public void testSetTiempoPreparacion() {
        System.out.println("setTiempoPreparacion");
        int tiempoPreparacion = 0;
        Articulo instance = null;
        instance.setTiempoPreparacion(tiempoPreparacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Articulo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Articulo instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
