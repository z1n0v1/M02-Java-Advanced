package L03SetsAndMapsAdvanced.Exercise.T03PeriodicTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> elements = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            List<String> compound = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            elements.addAll(compound);
        }
        elements.stream().sorted().forEach(e -> System.out.printf("%s ", e));
    }
}
