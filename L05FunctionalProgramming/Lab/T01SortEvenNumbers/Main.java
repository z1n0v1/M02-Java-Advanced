package L05FunctionalProgramming.Lab.T01SortEvenNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        numbers.removeIf(num -> num % 2 != 0);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        numbers.sort((a, b) -> a.compareTo(b));
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
