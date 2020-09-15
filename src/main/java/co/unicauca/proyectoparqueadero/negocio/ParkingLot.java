package co.unicauca.proyectoparqueadero.negocio;

import co.unicauca.proyectoparqueadero.negocio.manufactura.Utilities;
import java.util.Date;

/**
 * Represents a parking lot
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class ParkingLot {

    /**
     * Tax identification number
     */
    private long nit;

    /**
     * Business name of the parking name
     */
    private String businessName;

    /**
     * Constructors, getters, and setters
     */
    public ParkingLot() {
    }

    public ParkingLot(long nit, String businessName) {
        this.nit = nit;
        this.businessName = businessName;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * Method that indicates the date and time of entry of a vehicle to the
     * parking lot
     *
     * @param vehicle vehicle entering the parking lot
     * @param dateTimeEntry date and time of entry
     */
    public void enterParkingLot(Vehicle vehicle, Date dateTimeEntry) {
        vehicle.setDateTimeEntry(dateTimeEntry);
    }

    /**
     * Method that indicates the date and time of departure of a vehicle from a
     * parking lot and calculates the rate to pay
     *
     * @param vehicle vehicle leaving the parking lot
     * @param dateTimeDeparture date and time of departure
     * @return the rate to pay for the stay in the parking lot
     */
    public int exitParkingLot(Vehicle vehicle, Date dateTimeDeparture) {
        vehicle.setDateTimeDeparture(dateTimeDeparture);
        int rate;

        float hours = Utilities.getDateDiff(vehicle.getDateTimeEntry(), vehicle.getDateTimeDeparture()) / 60.0f;
        hours = Utilities.roundDecimals(hours, 2);
        System.out.println("Time elapsed: " + hours + " hours.");
        rate = Utilities.roundPayment(vehicle.rate(hours));

        return rate;
    }

}
