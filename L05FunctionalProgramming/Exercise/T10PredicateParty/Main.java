package L05FunctionalProgramming.Exercise.T10PredicateParty;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] data = input.split("\\s+");
            Predicate<String> predicate = getPredicate(data[1], data[2]);
            switch (data[0]) {
                case "Double":
                    for (int i = names.size() - 1; i >= 0 ; i--) {
                        if(predicate.test(names.get(i)))
                            names.add(names.get(i));
                    }
                    break;
                case "Remove":
                    names.removeIf(predicate);
                    break;
            }
            input = scanner.nextLine();
        }
        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(String.join(", ",
                    names.stream().sorted().toArray(String[]::new)));
            System.out.println(" are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String command, String parameter) {
        Predicate<String> predicate = null;
        switch (command) {
            case "StartsWith":
                predicate = name -> name.startsWith(parameter);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(parameter);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(parameter);
                break;
        }
        return predicate;
    }
}
