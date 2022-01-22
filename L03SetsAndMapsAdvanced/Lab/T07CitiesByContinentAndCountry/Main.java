package L03SetsAndMapsAdvanced.Lab.T07CitiesByContinentAndCountry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> towns = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            towns.putIfAbsent(tokens[0], new LinkedHashMap<>());
            towns.get(tokens[0]).putIfAbsent(tokens[1], new ArrayList<>());
            towns.get(tokens[0]).get(tokens[1]).add(tokens[2]);
        }
        towns.forEach((continent, countries) -> {
            System.out.printf("%s:%n", continent);
            countries.forEach((country, cities) -> {
                System.out.printf("%s -> ", country);
                System.out.println(String.join(", ", cities));
            });

        });
    }
}
