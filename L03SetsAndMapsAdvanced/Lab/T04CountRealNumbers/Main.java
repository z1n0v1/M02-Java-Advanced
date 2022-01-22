package L03SetsAndMapsAdvanced.Lab.T04CountRealNumbers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> numberCount = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach( num -> {
            if(numberCount.containsKey(num))
                numberCount.put(num, 1 + numberCount.get(num));
            else numberCount.put(num, 1);
        });
        numberCount.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
