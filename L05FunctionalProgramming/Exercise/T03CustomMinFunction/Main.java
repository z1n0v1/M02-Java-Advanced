package L05FunctionalProgramming.Exercise.T03CustomMinFunction;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Function<Integer[], Integer> minInt = nums -> {
          int min = Integer.MAX_VALUE;
          for (int num : nums)
              if (num < min)
                  min = num;
          return min;
        };
        System.out.println(minInt.apply(numbers));
    }
}
