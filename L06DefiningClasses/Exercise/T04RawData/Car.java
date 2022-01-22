package L06DefiningClasses.Exercise.T04RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    Car(String model, Integer engineSpeed, Integer enginePower, Integer cargoWeight, String cargoType,
        Integer tire1Age, Double tire1Pressure,
        Integer tire2Age, Double tire2Pressure,
        Integer tire3Age, Double tire3Pressure,
        Integer tire4Age, Double tire4Pressure) {
        this.model = model;
        engine = new Engine(engineSpeed, enginePower);
        cargo = new Cargo(cargoWeight, cargoType);
        tires = new Tire[4];
        tires[0] = new Tire(tire1Age, tire1Pressure);
        tires[1] = new Tire(tire2Age, tire2Pressure);
        tires[2] = new Tire(tire3Age, tire3Pressure);
        tires[3] = new Tire(tire4Age, tire4Pressure);
    }

    public String toString() { return model;}

    public boolean isFragile() {
        boolean isFragile = false;
        if (cargo.getType().equals("fragile")) {
            for (Tire tire : tires)
                if (tire.getPressure() < 1) {
                    isFragile = true;
                    break;
                }
        }
        return isFragile;
    }

    public boolean isFlamable() {
        boolean isFlamable = false;
        if (cargo.getType().equals("flamable")) {
            if (engine.getPower() > 250)
                isFlamable = true;
        }
        return isFlamable;
    }

}

