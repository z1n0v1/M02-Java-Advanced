package L03SetsAndMapsAdvanced.Exercise.T13SrypskoUnleashed;
// Сръбско Unleashed

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile
                ("(?<singer>[a-zA-Z\\s]+) @(?<venue>[a-zA-Z\\s]+) (?<price>[0-9]+) (?<quantity>[0-9]+)");

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Matcher data = pattern.matcher(input);
            if (data.find()) {
                String singer = data.group("singer");
                String venue = data.group("venue");
                int price = Integer.parseInt(data.group("price"));
                int quantity = Integer.parseInt(data.group("quantity"));
                if (!venues.containsKey(venue)) {
                    LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                    singers.put(singer, price * quantity);
                    venues.put(venue, singers);
                } else {
                    if (!venues.get(venue).containsKey(singer)) {
                        venues.get(venue).put(singer, price * quantity);
                    } else {
                        venues.get(venue).put(singer,
                                venues.get(venue).get(singer) + price * quantity);
                    }
                }

            }
            input = scanner.nextLine();
        }
        venues.forEach((venue, singers) -> {
            System.out.println(venue);
            singers.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(e -> {
                System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue());
            });
        });

    }
}
