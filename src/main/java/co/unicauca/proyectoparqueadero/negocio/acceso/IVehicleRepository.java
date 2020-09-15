package co.unicauca.proyectoparqueadero.negocio.acceso;

import co.unicauca.proyectoparqueadero.negocio.Vehicle;
import java.util.List;

/**
 * Provides abstract methods related to accessing the database
 * @author Juliana Mora - Yeferson Benavides
 */
public interface IVehicleRepository {

    //Vehicle methods 
    public boolean saveVehicle(Vehicle newVehicle);

    public List<Vehicle> listVehicles();
}
