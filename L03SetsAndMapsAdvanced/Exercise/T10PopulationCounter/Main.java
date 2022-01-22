package L03SetsAndMapsAdvanced.Exercise.T10PopulationCounter;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCityPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            if(!countryPopulation.containsKey(country))
                countryPopulation.put(country, population);
            else countryPopulation.put(country, countryPopulation.get(country) + population);

            if(!countryCityPopulation.containsKey(country)) {
                LinkedHashMap<String, Long> currentCity = new LinkedHashMap<>();
                currentCity.put(city, population);
                countryCityPopulation.put(country, currentCity);
            } else {
                if (!countryCityPopulation.get(country).containsKey(city)) {
                    countryCityPopulation.get(country).put(city, population);
                } else {
                    countryCityPopulation.get(country).put(country,
                            countryCityPopulation.get(country).get(city) + population);
                }
            }
            input = scanner.nextLine();
        }

        countryPopulation.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach( e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), e.getValue());
                    countryCityPopulation.get(e.getKey())
                            .entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
