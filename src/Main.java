import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Initialise Ship
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        Ship titanic = new Ship("Titanic", 20, destinations, passengers);

        //Add Passengers
        Passenger sander = new Passenger("Sander", 12, "standard", 20.5);
        Passenger justin = new Passenger("Justin", 29, "premium", 0);
        Passenger colin = new Passenger("Colin", 15, "senior", 85);
        Passenger theo = new Passenger("Theo", 39, "standard", 120);
        Passenger andy = new Passenger("Andy", 51, "standard", 500);

        titanic.addPassenger(sander);
        titanic.addPassenger(justin);
        titanic.addPassenger(colin);
        titanic.addPassenger(theo);
        titanic.addPassenger(andy);

        //Intialise destinations
        ArrayList<Activity> newYorkActivites = new ArrayList<>();
        Destination newYork = new Destination("New York", newYorkActivites);
        ArrayList<Activity> hongKongActivities = new ArrayList<>();
        Destination hongKong = new Destination("Hong Kong", hongKongActivities);
        titanic.addDestination(newYork);
        titanic.addDestination(hongKong);

        //Initialise Activities
        ArrayList<Actor> requiemStars = new ArrayList<>();
        TheatreShow requiem = new TheatreShow("Requiem", "Watch Drama Students Cook", 50, 1, hongKong, requiemStars);
        Actor maxwell = new Actor("Maxwell", "Hercules");
        Actor cyrus = new Actor("Cyrus", "Iron Man");
        requiem.addStar(maxwell);
        requiem.addStar(cyrus);
        VisitAttraction statueOfLiberty = new VisitAttraction("Statue of Liberty", "Visit the Statue of Liberty", 15.5, 2, newYork);
        WalkingTour tourKowloon = new WalkingTour("Kowloon Tour", "Go on a tour of kowloon", 90, 2, hongKong, 10);
        ArrayList<Actor> romeoAndJulietStars = new ArrayList<>();
        Actor Ryan = new Actor("Ryan", "Romeo");
        Actor Eric = new Actor("Eric", "Juliet");
        romeoAndJulietStars.add(Ryan);
        romeoAndJulietStars.add(Eric);
        TheatreShow romeoAndJuliet = new TheatreShow("Romeo and Juliet", "Watch Romeo and Juliet", 50, 4, newYork, romeoAndJulietStars);
        Activity bowling = new Activity("Bowling", "Go bowling", 20, 10, newYork);

        //Add Activites
        newYork.addActivity(statueOfLiberty);
        hongKong.addActivity(requiem);
        hongKong.addActivity(tourKowloon);
        newYork.addActivity(romeoAndJuliet);
        newYork.addActivity(bowling);

        System.out.println("TEST: Printing Itinerary" + "\n");
        titanic.printitinerary();

        System.out.println("TEST: Printing Passengers" + "\n");
        titanic.printPassengers();

        System.out.println("TEST: Joining Activities" + "\n");

        //theo should be able to join requiem
        titanic.joinActivity(theo, hongKong, requiem);

        //sander should not be able to join tourKowloon because he only has 20.5 dollars, while the activity costs 90 dollars
        titanic.joinActivity(sander, hongKong, tourKowloon);

        //justin should be able to join tourKowloon even though he has nothing in his balance because he is a premium passenger
        titanic.joinActivity(justin, hongKong, tourKowloon);

        //theo should not be able to join tourKowloon because he is already in another activity in Hong Kong
        titanic.joinActivity(theo, hongKong, tourKowloon);

        //colin only has 85 dollars while the tour costs 90 dollars, but he should still be able to join tourKowloon because he is a senior passenger who gets 10% discounts
        titanic.joinActivity(colin, hongKong, tourKowloon);

        //andy should not be able to join tourKowloon because tourKowloon has reaches its maximum capacity
        titanic.joinActivity(andy, hongKong, tourKowloon);

        //andy should be able to join statueOfLiberty
        titanic.joinActivity(andy, newYork, statueOfLiberty);

        //theo should be able to join statueOfLiberty
        titanic.joinActivity(theo, newYork, statueOfLiberty);

        System.out.println("--------------------------------------" + "\n");
        System.out.println("TEST: Printing Individual Passenger Details" + "\n");
        titanic.printPassenger(theo); //he is signed up for two activities
        titanic.printPassenger(justin); //justin should pay 0 dollars for his activities
        titanic.printPassenger(colin); //colin should pay 81 dollars for the 90 dollar kowloon tour because of his discount

        System.out.println("--------------------------------------" + "\n");
        System.out.println("TEST: Printing Activities with Space" + "\n");
        titanic.printActivitiesWithSpace(); //bowling and Romeo and Juliet should have spaces left since no one has signed up

    }

}
