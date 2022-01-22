package L03SetsAndMapsAdvanced.Exercise.T08HandsOfCards;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> playerCards = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split("\\: ");
            if(!playerCards.containsKey(data[0]))
                playerCards.put(data[0], new LinkedHashSet<>());
            Set<String> cards = Arrays.stream(data[1].split(", ")).collect(Collectors.toSet());
            playerCards.get(data[0]).addAll(cards);

            input = scanner.nextLine();
        }
    playerCards.forEach((player, cards) -> {
        int points = 0;
        for(String card : cards)
            points += cardToPoints(card);
        System.out.printf("%s: %d%n", player, points);
    });
    }

    static int cardToPoints(String card) {
        int points = 0;
        switch (card.charAt(0)) {
            case '1': points += 10; break;
            case '2': points += 2; break;
            case '3': points += 3; break;
            case '4': points += 4; break;
            case '5': points += 5; break;
            case '6': points += 6; break;
            case '7': points += 7; break;
            case '8': points += 8; break;
            case '9': points += 9; break;
            case 'J': points += 11; break;
            case 'Q': points += 12; break;
            case 'K': points += 13; break;
            case 'A': points += 14; break;
        }
        switch (card.charAt(card.length() -1)) {
            case 'S': points *= 4; break;
            case 'H': points *= 3; break;
            case 'D': points *= 2; break;
        }
        return points;
    }
}
