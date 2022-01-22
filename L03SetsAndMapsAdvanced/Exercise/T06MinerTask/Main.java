package L03SetsAndMapsAdvanced.Exercise.T06MinerTask;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if(!resources.containsKey(input))
                resources.put(input, quantity);
            else resources.put(input, resources.get(input) + quantity);
            input = scanner.nextLine();
        }
        resources.forEach((type, quantity) -> System.out.printf("%s -> %d%n", type, quantity));

    }
}
