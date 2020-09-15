package co.unicauca.proyectoparqueadero.negocio;

import java.util.Date;

/**
 * Represents a vehicle
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public abstract class Vehicle implements IRate {

    /**
     * Vehicle identificator
     */
    protected int vehicleId;

    /**
     * Vehicle plate
     */
    protected String plateNumber;

    /**
     * Vehicle brand
     */
    protected String brand;

    /**
     * Vehicle reference
     */
    protected String reference;

    /**
     * Vehicle type
     */
    protected String typeVehicle;

    /**
     * Date and time of entry to the parking lot
     */
    protected Date dateTimeEntry;

    /**
     * Date and time of departure from the parking lot
     */
    protected Date dateTimeDeparture;

    /**
     * Constructors, getters, and setters
     */
    public Vehicle() {

    }

    public Vehicle(int vehicleId, String plateNumber, String brand, String reference, String typeVehicle) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.reference = reference;
        this.typeVehicle = typeVehicle;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateTimeEntry() {
        return dateTimeEntry;
    }

    public void setDateTimeEntry(Date dateTimeEntry) {
        this.dateTimeEntry = dateTimeEntry;
    }

    public Date getDateTimeDeparture() {
        return dateTimeDeparture;
    }

    public void setDateTimeDeparture(Date dateTimeDeparture) {
        this.dateTimeDeparture = dateTimeDeparture;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    /**
     * Abstract method for calculating the rate
     *
     * @param hours floating value for the number of hours spent in the parking
     * lot
     */
    @Override
    public abstract int rate(float hours);

    /**
     * Method to represent any object as a string
     *
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        return "Vehicle{" + "vehicleId=" + vehicleId + ", plateNumber=" + plateNumber + ", brand=" + brand + ", reference=" + reference + ", typeVehicle=" + typeVehicle + ", dateTimeEntry=" + dateTimeEntry + ", dateTimeDeparture=" + dateTimeDeparture + '}';
    }

}
