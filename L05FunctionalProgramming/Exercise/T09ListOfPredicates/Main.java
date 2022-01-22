package L05FunctionalProgramming.Exercise.T09ListOfPredicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Predicate<Integer>> predicates = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt)
                .forEach(divisible -> {
                    Predicate<Integer> predicate = num ->  num % divisible  == 0;
                    predicates.add(predicate);
                });
        for (int num = 1; num <= n; num++) {
            boolean isDivisable = true;
            for (Predicate<Integer> predicate : predicates) {
                if(!predicate.test(num)) {
                    isDivisable = false;
                    break;
                }
            }
            if(isDivisable)
                System.out.printf("%d ", num);
        }
    }
}
