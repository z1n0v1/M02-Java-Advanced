package L08IteratorsAndComparators.Exercise.T05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            people.add(new Person(token[0], Integer.parseInt(token[1]), token[2]));
        }
        int n = Integer.parseInt(scanner.nextLine());

        long different = people.stream().filter(a -> a.compareTo(people.get(n - 1)) != 0).count();
        long same = people.size() - different;

        if(same == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", same, different, people.size());
        }
    }
}
