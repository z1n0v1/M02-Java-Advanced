package L06DefiningClasses.Exercise.T01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            people.add(new Person(name, age));
        }
        people.stream().filter(person -> person.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
