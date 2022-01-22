package L06DefiningClasses.Exercise.T04RawData;

public class Engine {
    private Integer speed;
    private Integer power;

    public Engine(Integer speed, Integer power) {
        this.speed = speed;
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }
}
