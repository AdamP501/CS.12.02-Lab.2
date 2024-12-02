import java.util.ArrayList;

public class TheatreShow extends Activity{
    private ArrayList<Actor> stars;
    public TheatreShow(String name, String description, double cost, int capacity, Destination destination, ArrayList<Actor> stars) {
        super(name, description, cost, capacity, destination);
        this.stars = stars;
    }
    public ArrayList<Actor> getStars() {
        return stars;
    }
    public void addStar(Actor actor){
        stars.add(actor);
    }

    public String toString(){

        StringBuilder starsList = new StringBuilder();
        for (Actor star : stars) {
            starsList.append(star.getName()).append(", ");
        }

        // Remove trailing comma and space
        if (starsList.length() > 0) {
            starsList.setLength(starsList.length() - 2);
        }

        return  "Activity Name: " + getName()+
                "\nDescription : " + getDescription()+
                "\nCost: " + getCost()+
                "\nCapacity: " + getCapacity()+
                "\nStars: " + starsList.toString();
    }
}
