public class Actor {
    private String name;
    private String charName;

    public Actor (String name, String charName){
        this.name = name;
        this.charName = charName;
    }
    public String getName() {
        return name;
    }

    public String getCharName() {
        return charName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
