package L08IteratorsAndComparators.Exercise.T04Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        Lake lake = new Lake(array);
//        for (int e : lake)
//            System.out.print(e + " ");
        Lake lake = new Lake(
                Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray()
        );
        scanner.nextLine();

        Iterator<Integer> iterator = lake.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                System.out.print(", ");
        }
    }
}
