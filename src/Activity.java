import java.util.ArrayList;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private ArrayList<Passenger> passengers;

    public Activity (String name, String description, double cost, int capacity, Destination destination){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }
    public int getCapacity() {
        return capacity;
    }
    public double getCost() {
        return cost;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }



    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public String toString(){
        return  "Activity Name: " + name+
                "\nDescription : " + description+
                "\nCost: " + cost+
                "\nCapacity: " + capacity;
    }
}
