package L06DefiningClasses.Exercise.T09CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Cat> cats = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Siamese":
                    cats.put(token[1], new Siamese(token[1], Double.parseDouble(token[2])));
                    break;
                case "Cymric":
                    cats.put(token[1], new Cymric(token[1], Double.parseDouble(token[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.put(token[1],new StreetExtraordinaire(token[1], Double.parseDouble(token[2])));
            }
        }
        input = scanner.nextLine();
        System.out.println(cats.get(input));
    }
}
