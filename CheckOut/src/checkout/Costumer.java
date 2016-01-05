package checkout;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Anestis
 */
public class Costumer implements Serializable{
    
    private String vehicleType;
    private String vehicleNumber;
    private ArrayList<Integer> servArray;
    private String timeInsert;
    private String timeOut;
    private int cost;

    /**
     * Constructor of Costumer class.
     * @param vehicleType The type of the vehicle(car, bike, truck).
     * @param vehicleNumber The number of the vehivle plate.
     * @param servArray An ArrayList of the services choosen by the client.
     * @param cost The total cost of the services.
     * @param timeInsert The time the vehicle was inserted in the garage.
     */
    public Costumer(String vehicleType, String vehicleNumber, ArrayList<Integer> servArray,int cost, String timeInsert) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.servArray = servArray;
        this.timeInsert = timeInsert;
        this.cost=cost;
        this.timeOut="-";
    }

    /**
     * Returns the time of the payment.
     * @return timeOut
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * Gets the cost of the services.
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets the time of the payment.
     * @param timeOut 
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Gets the type of the vehicle.
     * @return vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Returns the number plate of the vehivle.
     * @return vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Returns the ArrayList with the services supplied.
     * @return servArray
     */
    public ArrayList<Integer> getServArray() {
        return servArray;
    }

    /**
     * Returns the time the vehicle was inserted.
     * @return timeInsert
     */
    public String getTimeInsert() {
        return timeInsert;
    }
    
}
