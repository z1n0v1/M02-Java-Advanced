package L03SetsAndMapsAdvanced.Exercise.T02SetsOfElements;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(),
                secondSet = new LinkedHashSet<>();

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        while (sizes[0]-- > 0) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        while (sizes[1]-- > 0) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSet.forEach(num -> {
            if (secondSet.contains(num))
                System.out.printf("%d ", num);
        });

//        while (sizes[1]-- > 0) {
//            int num = Integer.parseInt(scanner.nextLine());
//            if(firstSet.contains(num))
//                secondSet.add(num);
//        }
//        secondSet.forEach(num -> System.out.printf("%d ", num));
    }
}
