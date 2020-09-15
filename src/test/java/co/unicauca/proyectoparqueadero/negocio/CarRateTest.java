package co.unicauca.proyectoparqueadero.negocio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class CarRateTest {
    
    public CarRateTest() {
    }
    
    /**
     * Test of rate method, of class CarRate.
     */
    @Test
    public void testRate() {
        System.out.println("rate");
        float hours = 0.0F;
        CarRate instance = new CarRate();
        int expResult = 0;
        int result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 0.7F;
        expResult = 2000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 1F;
        expResult = 2000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 12.5F;
        expResult = 13500;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 38.2F;
        expResult = 39200;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
}
