package L07Generics.Exercise.T06GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Double>> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            list.add(new Box<>(Double.parseDouble(scanner.nextLine())));
        }
        System.out.println(greatherThan(list, new Box<>(Double.parseDouble(scanner.nextLine()))));
    }

    static  <T extends Comparable<T>> int greatherThan(List<T> list, T element) {
        int count = 0;
        for (T currentElement : list)
            if (currentElement.compareTo(element) > 0)
                count++;
        return count;
    }
}
