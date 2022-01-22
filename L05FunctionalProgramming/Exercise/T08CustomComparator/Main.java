package L05FunctionalProgramming.Exercise.T08CustomComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> comparator = (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0)
                return -1;
            if (a % 2 != 0 && b % 2 == 0)
                return 1;
            return a.compareTo(b);
        };
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(num -> System.out.printf("%d ", num));
    }
}
