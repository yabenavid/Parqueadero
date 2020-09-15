package co.unicauca.proyectoparqueadero.cliente;

import co.unicauca.proyectoparqueadero.negocio.*;
import co.unicauca.proyectoparqueadero.negocio.acceso.*;
import co.unicauca.proyectoparqueadero.negocio.servicio.Service;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public class ClienteMain {

    /**
     * Starter
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ParkingLot parking = new ParkingLot(5566789, "PL");
        IVehicleRepository repository = new VehicleRepository();
        Service service = new Service(repository);
        
        Vehicle moto = new MotorcycleRate(123, "TRT-432", "Honda", "CB", "Motorcycle");
        
        parking.enterParkingLot(moto, new Date(120, 8, 13, 14, 30));
        service.saveVehicle(moto);
        
        String entry = moto.getDateTimeEntry().toString();

        System.out.println("Motorcycle:\nEntry: " + entry);
        int rateMoto = parking.exitParkingLot(moto, new Date(120, 8, 13, 20, 00));
        String departure = moto.getDateTimeDeparture().toString();
        System.out.println("Departure: " + departure);
        System.out.println("Payment amount: $" + rateMoto + "\n");
        

        Vehicle truck = new TruckRate(124, "ABC-402", "Hino", "Dutro", "Truck");
        
        parking.enterParkingLot(truck, new Date(120, 8, 13, 8, 00));
        service.saveVehicle(truck);
        
        entry = truck.getDateTimeEntry().toString();
        System.out.println("Truck:\nEntry: " + entry);
        int rateTruck = parking.exitParkingLot(truck, new Date(120, 8, 14, 12, 00));
        departure = truck.getDateTimeDeparture().toString();
        System.out.println("Departure: " + departure);
        System.out.println("Payment amount: $" + rateTruck + "\n");
        
        
        Vehicle car = new CarRate(125, "GHJ-420", "Volvo", "XC90", "Car");
        
        parking.enterParkingLot(car, new Date(120, 8, 13, 8, 00));
        service.saveVehicle(car);
        
        entry = car.getDateTimeEntry().toString();
        System.out.println("Car:\nEntry: " + entry);
        int rateCar = parking.exitParkingLot(car, new Date(120, 8, 15, 8, 00));
        departure = car.getDateTimeDeparture().toString();
        System.out.println("Departure: " + departure);
        System.out.println("Payment amount: $" + rateCar + "\n");
        
        List<Vehicle> vehicles = service.listVehicles();
        
        for(int i=0; i<vehicles.size(); i++){
            System.out.println(vehicles.get(i).toString());
        }
    }

}
