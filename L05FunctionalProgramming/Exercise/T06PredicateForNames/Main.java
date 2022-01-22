package L05FunctionalProgramming.Exercise.T06PredicateForNames;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> lengthLessThan = name -> name.length() <= length;
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(lengthLessThan).forEach(System.out::println);
    }
}
