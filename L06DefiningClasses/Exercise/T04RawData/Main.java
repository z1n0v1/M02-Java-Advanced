package L06DefiningClasses.Exercise.T04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];

            Integer engineSpeed = Integer.parseInt(data[1]);
            Integer enginePower = Integer.parseInt(data[2]);

            Integer cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            Integer tire1Age = Integer.parseInt(data[6]);
            Double tire1Pressure = Double.parseDouble(data[5]);

            Integer tire2Age = Integer.parseInt(data[8]);
            Double tire2Pressure = Double.parseDouble(data[7]);

            Integer tire3Age = Integer.parseInt(data[10]);
            Double tire3Pressure = Double.parseDouble(data[9]);

            Integer tire4Age = Integer.parseInt(data[12]);
            Double tire4Pressure = Double.parseDouble(data[11]);

            cars.add(new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tire1Age, tire1Pressure, tire2Age, tire2Pressure,
                    tire3Age, tire3Pressure, tire4Age, tire4Pressure));
        }

        String command = scanner.nextLine();
        cars.forEach(car -> {
            if(command.equals("fragile")) {
                if (car.isFragile())
                    System.out.println(car);
            } else {
                if (car.isFlamable())
                    System.out.println(car);
            }
        });
    }
}
