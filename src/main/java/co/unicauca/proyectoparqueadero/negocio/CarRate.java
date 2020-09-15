package co.unicauca.proyectoparqueadero.negocio;

/**
 * Represents a car
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class CarRate extends Vehicle {

    /**
     * Constructors
     */
    public CarRate() {
    }

    public CarRate(int vehicleId, String plateNumber, String brand, String reference, String typeVehicle) {
        super(vehicleId, plateNumber, brand, reference, typeVehicle);
    }

    /**
     * Implements the parent class method to calculate the rate
     *
     * @param hours floating value for the number of hours spent in the parking
     * lot
     * @return the rate calculated as an integer value
     */
    @Override
    public int rate(float hours) {

        float rate;
        if (hours == 0){
            rate = 0;
        }
        else if (hours <= 1) {
            rate = 2000;
        } 
        else {
            rate = 2000 + (hours - 1) * 1000;
        }
        return (int) (rate);
    }
}
