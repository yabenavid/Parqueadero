package co.unicauca.proyectoparqueadero.negocio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class MotorcycleRateTest {
    
    public MotorcycleRateTest() {
    }

    /**
     * Test of rate method, of class MotorcycleRate.
     */
    @Test
    public void testRate() {
        System.out.println("rate");
        float hours = 0.0F;
        MotorcycleRate instance = new MotorcycleRate();
        int expResult = 0;
        int result = instance.rate(hours);
        assertEquals(expResult, result);
        
        hours = 0.7F;
        expResult = 1000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 1F;
        expResult = 1000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 12.5F;
        expResult = 6750;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 38.2F;
        expResult = 19600;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
