package L05FunctionalProgramming.Exercise.T05ReverseAndExclude;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        list.removeIf(num -> num % n == 0);
        Collections.reverse(list);
        list.forEach(num -> System.out.printf("%d ", num));
        System.out.println();
    }
}
