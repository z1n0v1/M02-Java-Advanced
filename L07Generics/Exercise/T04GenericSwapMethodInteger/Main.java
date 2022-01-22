package L07Generics.Exercise.T04GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        int[] index = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        swapIndex(list, index[0], index[1]);
        list.forEach(element -> {
            System.out.printf("%s: %s%n", element.getClass().getName(), element);
        });
    }

    private static <T> void swapIndex(List<T> list, int leftIndex, int rightIndex) {
        T temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
    }
}
