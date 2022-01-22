package L06DefiningClasses.Exercise.T05CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%n",
                model, power, displacement, efficiency);
    }
}
