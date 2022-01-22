package L06DefiningClasses.Exercise.T04RawData;

public class Cargo {
    Integer weight;
    String type;

    public String getType() {
        return type;
    }

    public Cargo(Integer weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}
