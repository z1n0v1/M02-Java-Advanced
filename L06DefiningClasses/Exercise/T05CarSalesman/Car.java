package L06DefiningClasses.Exercise.T05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public String toString() {
        return String.format("%s:%n%sWeight: %s%nColor: %s",model,engine,weight,color);
    }
}
