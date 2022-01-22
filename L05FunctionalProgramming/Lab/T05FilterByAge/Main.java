package L05FunctionalProgramming.Lab.T05FilterByAge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split(",\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            people.put(name, age);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(people, tester, printer);
    }

    private static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey())))
                printer.accept(person);
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.println(person.getKey());
                break;
            case "age":
                printer = person -> System.out.println(person.getValue());
        }
        return printer;
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = x -> x <= age;
                break;
            case "older":
                tester = x -> x >= age;
        }
        return tester;
    }
}
