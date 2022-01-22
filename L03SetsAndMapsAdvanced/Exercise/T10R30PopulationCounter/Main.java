package L03SetsAndMapsAdvanced.Exercise.T10R30PopulationCounter;

import java.util.*;

// How to order by entry ?

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> countryPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> citiesPopulation = new LinkedHashMap<>();
        List<String> cityOrder = new ArrayList<>();

        String s = scanner.nextLine();
        while (!s.equals("report")) {
            String[] data = s.split("\\|");
            String city = data[0];
            String country = data[1];
            int population = Integer.parseInt(data[2]);
            cityOrder.add(city);

            if (!citiesPopulation.containsKey(country)) {
                LinkedHashMap<String, Integer> currentCity= new LinkedHashMap<>();
                currentCity.put(city, population);
                citiesPopulation.put(country, currentCity);
            } else {
                citiesPopulation.get(country).put(city, population);
            }

            if(!countryPopulation.containsKey(country))
                countryPopulation.put(country, population);
            else countryPopulation.put(country, countryPopulation.get(country) + population);

            s = scanner.nextLine();
        }

        countryPopulation.entrySet().stream().sorted((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        }).forEach((country) -> {
            System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());
            citiesPopulation.get(country.getKey()).entrySet().stream().sorted((a, b) -> {
                if(b.getValue().equals(a.getValue()))
                    return cityOrder.indexOf(b.getValue()) - cityOrder.indexOf(a.getValue());
                return b.getValue().compareTo(a.getValue());
            }).forEach((city) -> {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            });
        });
    }
}
