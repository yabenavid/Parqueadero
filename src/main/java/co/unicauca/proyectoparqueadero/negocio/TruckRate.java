package co.unicauca.proyectoparqueadero.negocio;

/**
 * Represents a truck
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class TruckRate extends Vehicle {

    /**
     * Constructors
     */
    public TruckRate() {
    }

    public TruckRate(int vehicleId, String plateNumber, String brand, String reference, String typeVehicle) {
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
        else if (hours <= 12) {
            rate = 10000;
        } 
        else if (hours > 12 && hours <= 24) {
            rate = 15000;
        } else {
            rate = 15000 + (hours - 24) * 625;
        }

        if (raffle() == true) {
            rate = 0;
        }
        return (int) (rate);
    }

    /**
     * Method that performs a raffle for truckers where the one who gets the
     * number 1000 randomly will not have to pay the rate
     *
     * @return true if it is the winning number and false otherwise
     */
    public boolean raffle() {
        boolean winner = false;
        int numSorteo = (int) (Math.random() * 1000);
        System.out.println("Number obtained in the draw: " + numSorteo);
        if (numSorteo == 1000) {
            System.out.println("Congratulations, !You won!");
            winner = true;
        }
        return winner;
    }
}
