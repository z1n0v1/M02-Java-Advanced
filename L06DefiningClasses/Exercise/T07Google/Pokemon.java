package L06DefiningClasses.Exercise.T07Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return String.format("%s %s", name, type);
    }
}
