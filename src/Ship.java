import java.util.ArrayList;

public class Ship {
    private String name;
    private int capacity;
    private ArrayList<Destination> itinerary;
    private ArrayList<Passenger> passengers;

    public Ship(String name, int capacity, ArrayList<Destination> itinerary, ArrayList<Passenger> passengers){
        this.name = name;
        this.capacity = capacity;
        this.itinerary = itinerary;
        this.passengers = passengers;
    }
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public void addDestination(Destination destination){
        itinerary.add(destination);
    }

    public void printitinerary(){
        System.out.println("Ship Name: " + name);
        System.out.println("\n"+"--------------------------------------"+"\n");
        for (Destination destination : itinerary){
            System.out.println("Desination: " + destination.getName() + "\n");
            for (Activity activity : destination.getAllActivities()){
                System.out.println(activity + "\n");
            }
            System.out.println("--------------------------------------"+"\n");
        }

    }

    public void printPassengers(){
        System.out.println("Ship Name: " + name);
        System.out.println("Passenger Capacity: " + capacity);
        System.out.println("Current Number of Passengers: " + passengers.size()+"\n");
        System.out.println("Passenger List: ");
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        System.out.println("--------------------------------------" + "\n");
    }

    public void joinActivity(Passenger passenger, Destination destination, Activity activity){
        boolean error = false;

        //adjust costs based on discounts
        double activityCost = activity.getCost();
        if (passenger.getType().equals("senior")){
            activityCost = activityCost * 0.9;
        }
        else if (passenger.getType().equals("premium")){
            activityCost = 0;
        }

        //check if passenger is already in an activity in that destination
        for (Activity tempActivity : destination.getAllActivities()){
            if (tempActivity.getPassengers().contains(passenger)){
                error = true;
                System.out.println("Error: " + passenger.getName() + " cannot join " + activity.getName() + " because they are already in " + tempActivity.getName());
            }
            break;
        }

        //check if passenger has enough money
        if (!error && (passenger.getBalance()-activityCost) < 0){
            error = true;
            System.out.println("Error: " + passenger.getName() + " does not have enough money in their balance to join " + activity.getName());
        }

        //check if the activity is at maximum capacity
        else if (activity.getPassengers().size() == activity.getCapacity()){
            error = true;
            System.out.println("Error: " + passenger.getName() + " cannot join " + activity.getName() + " because the activity is at maximum capacity");
        }

        //if there is no error, add the passenger
        if (error == false){
            activity.addPassenger(passenger);
            if (!passenger.getType().equals("premium")){
                passenger.setBalance(passenger.getBalance() - activityCost);
            }
            System.out.println(passenger.getName() + " has been added to the " + activity.getName() + " activity in " + destination.getName());
        }

    }

    public void printPassenger(Passenger passenger){
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getNumber());
        if (passenger.getType().equals("premium")){
            System.out.println("Passenger Balance: Premium");
        }
        else {
            System.out.println("Passenger Balance: " + passenger.getBalance() + "\n");
        }
        System.out.println(passenger.getName() + " is signed up for the following activities:" + "\n");
        for (Destination destination : itinerary){
            for (Activity activity : destination.getAllActivities()){
                if (activity.getPassengers().contains(passenger)){  //check if the passenger is signed up for that activity

                    //print how much they paid based on discounts
                    System.out.println(activity);
                    if (passenger.getType().equals("senior")){
                        System.out.println("The Passenger paid: " + (0.9 * activity.getCost()) + " dollars for this activity" + "\n");
                    }
                    else if (passenger.getType().equals("premium")){
                        System.out.println("The Passenger paid 0 dollars for this activity" + "\n");
                    }
                    else{
                        System.out.println("The Passenger paid " + activity.getCost() + " dollars for this activity" + "\n");
                    }
                }
            }
        }

    }

    //print the activity if its ArrayList of passengers is empty
    public void printActivitiesWithSpace(){
        System.out.println("The following activities still have space: ");
        for (Destination destination : itinerary){
            for (Activity activity : destination.getAllActivities()){
                if (activity.getCapacity() > activity.getPassengers().size()){
                    System.out.println(activity.getName() + " has " + (activity.getCapacity() - activity.getPassengers().size()) + " spaces left");
                }
            }
        }
    }

}
