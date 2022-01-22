package L06DefiningClasses.Lab.T01CarInfo;

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
            cars.add(new Car(data[0], data[1], Integer.parseInt(data[2])));
        }
        for (Car car : cars)
            System.out.println(car.carInfo());
    }
}
