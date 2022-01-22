package L06DefiningClasses.Exercise.T03SpeedRacing;

public class Car {
    private String model;
    private Double amount;
    private Double cost;
    private Integer distance;

    public Car(String model, Double amount, Double cost) {
        this.model = model;
        this.amount = amount;
        this.cost = cost;
        this.distance = 0;
    }

    public String toString() {
        return String.format("%s %.2f %d", model, amount, distance);
    }

    public boolean canMove(Integer distance) {
        return distance * cost <= amount;
    }

    public void move(Integer distance) {
        if (canMove(distance)) {
            this.distance += distance;
            this.amount -= distance * cost;
        }
    }
}
