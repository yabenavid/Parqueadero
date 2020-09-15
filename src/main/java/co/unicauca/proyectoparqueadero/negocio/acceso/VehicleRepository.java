package co.unicauca.proyectoparqueadero.negocio.acceso;

import co.unicauca.proyectoparqueadero.negocio.*;
import co.unicauca.proyectoparqueadero.negocio.servicio.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Allows direct interaction with the database
 * @author Juliana Mora - Yeferson Benavides
 */
public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    /**
     * Constructor
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Allows you to store the vehicle data in the Vehicle table of the DB
     * @param newVehicle Vehicle to save
     * @return "True" if the vehicle data was stored in the DB. "False" otherwise
     */
    @Override
    public boolean saveVehicle(Vehicle newVehicle) {

        try {
            //Validate vehicle
            if (newVehicle == null || newVehicle.getVehicleId() <= 0) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Vehicle ( vehicleId, plateNumber, brand, reference, typeVehicle, dateTimeEntry) "
                    + "VALUES ( ?, ?, ?, ?, ?, ? )";

            // En esta linea de código estamos indicando el nuevo formato que queremos para nuestra fecha.
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
            // Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String dateEntry = formatter.format(newVehicle.getDateTimeEntry());
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newVehicle.getVehicleId());
            pstmt.setString(2, newVehicle.getPlateNumber());
            pstmt.setString(3, newVehicle.getBrand());
            pstmt.setString(4, newVehicle.getReference());
            pstmt.setString(5, newVehicle.getTypeVehicle());
            pstmt.setString(6, dateEntry);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Allows to list the vehicles stored in the database
     * @return A list containing the vehicles
     */
    @Override
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT vehicleId, plateNumber, brand, reference, typeVehicle, dateTimeEntry, dateTimeDeparture FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Vehicle newVehicle;
            while (rs.next()) {
                
                if (rs.getString("typeVehicle").compareToIgnoreCase("Motorcycle") == 0){
                    newVehicle = new MotorcycleRate();
                }
                else if (rs.getString("typeVehicle").compareToIgnoreCase("Car") == 0){
                    newVehicle = new CarRate();
                }
                else{
                    newVehicle = new TruckRate();
                }
                
                newVehicle.setVehicleId(rs.getInt("VehicleId"));
                newVehicle.setBrand(rs.getString("Brand"));
                newVehicle.setReference(rs.getString("Reference"));
                newVehicle.setPlateNumber(rs.getString("PlateNumber"));
                newVehicle.setTypeVehicle(rs.getString("typeVehicle"));
                Date dateEntry = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("dateTimeEntry"));
                newVehicle.setDateTimeEntry(dateEntry);
                //newVehicle.setDateTimeDeparture(rs.getTimestamp("dateTimeDeparture"));

                vehicles.add(newVehicle);

            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    /**
     * Initialize the database by creating a Vehicle table if it does not exist
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	vehicleId integer PRIMARY KEY,\n"
                + "	plateNumber text NOT NULL,\n"
                + "	brand text,\n"
                + "     reference text,\n"
                + "     typeVehicle text NOT NULL,\n"
                + "     dateTimeEntry text NOT NULL,\n"
                + "     dateTimeDeparture text\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Allows you to connect to the database
     */
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";
        
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Allows you to disconnect from the database
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
