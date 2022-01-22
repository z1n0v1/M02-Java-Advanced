package L06DefiningClasses.Exercise.T07Google;

public class Car {
    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    public String toString() {
        return String.format("%s %s", model, speed);
    }
}
