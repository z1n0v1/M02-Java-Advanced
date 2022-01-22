package L08IteratorsAndComparators.Exercise.T06R80StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> people1 = new TreeSet<>(new CompareByNameLength()),
                people2 = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] personData = scanner.nextLine().split("\\s+");
            final Person person = new Person(personData[0], Integer.parseInt(personData[1]));
            people1.add(person);
            people2.add(person);
        }

        for (Person person : people1)
            System.out.println(person);
//        System.out.println();
        for (Person person : people2)
            System.out.println(person);

    }
}
