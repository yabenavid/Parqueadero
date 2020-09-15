package co.unicauca.proyectoparqueadero.negocio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class TruckRateTest {
    
    public TruckRateTest() {
    }
 
    /**
     * Test of rate method, of class TruckRate.
     */
    @Test
    public void testRate() {
        System.out.println("rate");
        float hours = 0.0F;
        TruckRate instance = new TruckRate();
        int expResult = 0;
        int result = instance.rate(hours);
        assertEquals(expResult, result);
        
        hours = 0.7F;
        expResult = 10000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 12F;
        expResult = 10000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 24F;
        expResult = 15000;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        hours = 38.2F;
        expResult = 23900;
        result = instance.rate(hours);
        assertEquals(expResult, result, 100);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
