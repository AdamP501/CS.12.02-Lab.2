public class Passenger {
    private String name;
    private int number;
    private String type;
    private double balance;

    public Passenger(String name, int number, String type, double balance){
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString(){
        return "Name: " + name + "       Number: " + number;
    }
}
