package L06DefiningClasses.Exercise.T04RawData;

public class Tire {
    Integer age;
    Double pressure;

    public Double getPressure() {
        return pressure;
    }

    public Tire(Integer age, Double pressure) {
        this.age = age;
        this.pressure = pressure;
    }
}
