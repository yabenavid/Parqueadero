package co.unicauca.proyectoparqueadero.negocio.servicio;

import co.unicauca.proyectoparqueadero.negocio.acceso.IVehicleRepository;
import co.unicauca.proyectoparqueadero.negocio.acceso.VehicleRepository;
import co.unicauca.proyectoparqueadero.negocio.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class Service {
    
    /**
     * Dependence on an abstraction
     */
    private IVehicleRepository repository;

    public Service() {
        repository = new VehicleRepository();
    }

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Save the product in the database
     * @param newVehicle vehicle to be recorded
     * @return true if it is recorded in the db, false otherwise
     */
    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getVehicleId() < 0) {
            return false;
        }

        repository.saveVehicle(newVehicle);
        return true;

    }

    /**
     * List vehicles
     * @return Vehicle List
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.listVehicles();;

        return vehicles;
    }
}
