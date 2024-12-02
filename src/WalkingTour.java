import java.util.ArrayList;

public class WalkingTour extends Activity{
    private double distance;

    public WalkingTour(String name, String description, double cost, int capacity, Destination destination, int distance) {
        super(name, description, cost, capacity, destination);
        this.distance = distance;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String toString(){
        return  "Activity Name: " + getName()+
                "\nDescription : " + getDescription()+
                "\nCost: " + getCost()+
                "\nCapacity: " + getCapacity()+
                "\nDistance: " + distance + " kilometers";
    }
}
