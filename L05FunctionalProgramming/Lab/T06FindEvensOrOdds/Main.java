package L05FunctionalProgramming.Lab.T06FindEvensOrOdds;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String type = scanner.nextLine();
        Predicate<Integer> check = checkEvenOrOdd(type);
        for (int i = range[0]; i <= range[1]; i++) {
            if (check.test(i))
                System.out.printf("%d ", i);
        }
    }

    private static Predicate<Integer> checkEvenOrOdd(String type) {
        Predicate<Integer> check = null;
        switch (type) {
            case "even":
                check = x -> x % 2 == 0;
                break;
            case "odd":
                check = x -> x % 2 != 0;
                break;
        }
        return check;
    }
}
