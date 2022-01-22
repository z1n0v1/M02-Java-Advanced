package L08IteratorsAndComparators.Exercise.T02Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listy = null;

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Create":
                    String[] strings = new String[token.length - 1];
                    for (int i = 0; i < token.length - 1; i++) {
                        strings[i] = token[i + 1];
                    }
                    listy = new ListyIterator(strings);
                    break;
                case "Move":
                    System.out.println(listy.move());
                    break;
                case "Print":
                    listy.print();
                    break;
                case "HasNext":
                    System.out.println(listy.hasNext());
                    break;
                case "PrintAll":
                    for (String s : listy)
                        System.out.print(s + " ");
                    System.out.println();
                    break;
            }
        }
    }
}
