package L06DefiningClasses.Exercise.T03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car = new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
            cars.put(data[0], car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String model = data[1];
            Integer distance = Integer.parseInt(data[2]);
            if (!cars.get(model).canMove(distance)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                cars.get(model).move(distance);
            }
            input = scanner.nextLine();
        }
        cars.forEach((model,car) -> System.out.println(car));
    }
}
