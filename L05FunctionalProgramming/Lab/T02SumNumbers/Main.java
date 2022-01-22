package L05FunctionalProgramming.Lab.T02SumNumbers;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");
        if (numbers.length < 2) {
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + numbers[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String num : numbers)
                sum += parser.apply(num);
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + sum);
        }
    }
}
