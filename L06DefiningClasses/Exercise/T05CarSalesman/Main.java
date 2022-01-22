package L06DefiningClasses.Exercise.T05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (data.length == 4) {
                displacement = data[2];
                efficiency = data[3];
            } else if (data.length == 3) {
                if(isNumber(data[2])) {
                    displacement = data[2];
                } else {
                    efficiency = data[2];
                }
            }
            engines.put(model, new Engine(model, power, displacement, efficiency));
        }
        n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = engines.get(data[1]);
            String weight = "n/a";
            String color = "n/a";
            if (data.length == 4) {
                weight = data[2];
                color = data[3];
            } else if (data.length == 3) {
                if (isNumber(data[2])) {
                    weight = data[2];
                } else {
                    color = data[2];
                }
            }
            cars.add(new Car(model, engine, weight, color));
        }

        cars.forEach(System.out::println);
    }

    static boolean isNumber(String s) {
        for (char c : s.toCharArray())
            if (!Character.isDigit(c))
                return false;
        return true;
    }
}
