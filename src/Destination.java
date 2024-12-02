import java.util.ArrayList;

public class Destination {
    private String name;
    private ArrayList<Activity> activities;

    public Destination (String name, ArrayList<Activity> activities){
        this.name = name;
        this.activities = activities;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Activity> getAllActivities(){
        return activities;
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }
}
