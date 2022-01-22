package L05FunctionalProgramming.Exercise.T04AppliedArithmetics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if(input.equals("print")) {
                numbers.forEach(num -> System.out.printf("%d ", num));
                System.out.println();
            } else {
                numbers = numbers.stream().map(getOperator(input)).collect(Collectors.toList());
            }
            input = scanner.nextLine();
        }
    }

    private static Function<Integer,Integer> getOperator(String input) {
        Function<Integer, Integer> operator = null;
        switch (input) {
            case "add":
                operator = num -> ++num;
                break;
            case "multiply":
                operator = num -> num *= 2;
                break;
            case "subtract":
                operator = num -> --num;
                break;
        }
        return operator;
    }
}
