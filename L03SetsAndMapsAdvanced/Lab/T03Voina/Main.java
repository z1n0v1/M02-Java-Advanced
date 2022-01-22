package L03SetsAndMapsAdvanced.Lab.T03Voina;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            int firstNumber = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstNumber);

            int secondNumber = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayerDeck.add(firstNumber);
                firstPlayerDeck.add(secondNumber);
            } else if(firstNumber < secondNumber) {
                secondPlayerDeck.add(firstNumber);
                secondPlayerDeck.add(secondNumber);
            }
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty())
                break;
        }
        if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
