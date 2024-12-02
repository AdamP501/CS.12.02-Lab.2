import java.util.ArrayList;

public class VisitAttraction extends Activity{
    public VisitAttraction(String name, String description, double cost, int capacity, Destination destination) {
        super(name, description, cost, capacity, destination);
    }

    public String toString() {
        return "Activity Name: " + getName() +
                "\nDescription : " + getDescription() +
                "\nCost: " + getCost() +
                "\nCapacity: " + getCapacity();
    }

    }

