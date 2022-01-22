package L05FunctionalProgramming.Exercise.T07FindTheSmallestElement;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> minIndex = list -> {
            int currentMin = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= currentMin) {
                    currentMin = list.get(i);
                    index = i;
                }
            }
            return index;
        };
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(minIndex.apply(list));
    }
}
