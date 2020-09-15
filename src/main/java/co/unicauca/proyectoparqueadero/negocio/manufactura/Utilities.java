package co.unicauca.proyectoparqueadero.negocio.manufactura;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Set of various utilities related to rounding numbers and operations with dates
 * @author Juliana Mora - Yeferson Benavides
 */
public class Utilities{

    /**
     * Method to round the number of hours a vehicle remains in the parking lot
     *
     * @param initValue floating initial value to round the number of hours to
     * two decimal places
     * @param cantDecimals number of decimal places required
     * @return a value rounded to 2 decimal places
     */
    public static float roundDecimals(float initValue, int cantDecimals) {
        float integerPart, result;
        result = initValue;
        integerPart = (float) Math.floor(result);
        result = (float) ((result - integerPart) * Math.pow(10, cantDecimals));
        result = Math.round(result);
        result = (float) (result / Math.pow(10, cantDecimals)) + integerPart;
        return result;
    }

    /**
     * Method that rounds the rate to the nearest hundred above the initial
     * value
     *
     * @param initValue initial value of the rate
     * @return the value rounded to the nearest hundred above the initial value
     */
    public static int roundPayment(int initValue) {
        double result, decimal;

        decimal = initValue % 1000;
        result = (initValue - decimal) + (Math.ceil(decimal / 100)) * 100;

        return (int) result;
    }
    
     /**
     * Method that calculates the difference between the date and time of entry and he date and time of exit for a vehicle
     * from the parking lot
     *
     * @param DateTimeEntry date and time of entry of a vehicle to the parking
     * lot.
     * @param dateTimeDeparture date and time of departure of a vehicle from the
     * parking lot
     * @return the difference between the entry and exit time
     */
    public static long getDateDiff(Date DateTimeEntry, Date dateTimeDeparture) {
        long diffInMillies = dateTimeDeparture.getTime() - DateTimeEntry.getTime();
        TimeUnit tm = TimeUnit.MINUTES;
        return tm.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
