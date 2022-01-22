package L07Generics.Exercise.T10R50Tuple;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");
        Tuple<String, String> person = new Tuple<>(token[0], token[1]);
        String adress = "";
        for (int i = 2; i < token.length; i++) {
            adress += token[i] + " ";
        }
        Tuple<Tuple<String, String>, String> personArdress = new Tuple<>(person, adress);

        token = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> personBeer = new Tuple<>(token[0], Integer.parseInt(token[1]));

        token = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> integerDoubleTuple =
                new Tuple<>(Integer.parseInt(token[0]), Double.parseDouble(token[1]));

        System.out.printf("%s %s -> %s%n", personArdress.getItem1().getItem1(),
                personArdress.getItem1().getItem2(), personArdress.getItem2());
        System.out.printf("%s -> %d%n", personBeer.getItem1(), personBeer.getItem2());
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setMaximumFractionDigits(340);
        System.out.printf("%d -> %s", integerDoubleTuple.getItem1(), decimalFormat.format(integerDoubleTuple.getItem2()));



//        Tuple<Person, String>
    }
}
