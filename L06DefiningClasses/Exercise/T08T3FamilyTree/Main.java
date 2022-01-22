package L06DefiningClasses.Exercise.T08T3FamilyTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        LinkedHashMap<String, List<String>> parents = new LinkedHashMap<>();
        String startFrom = scanner.nextLine();

        String input;
        while(!"End".equals(input = scanner.nextLine())) {
            if(input.contains("-")) {
                String[] token = input.split(" - ");
                parents.putIfAbsent(token[0], new ArrayList<>());
                parents.get(token[0]).add(token[1]);
            } else {
                String[] token = input.split("\\s+");
                String name = token[0] + " " + token[1];
                String date = token[2];
                people.add(new Person(name, date));
            }
        }
        parents.forEach((currentParent, children) -> {
            Person parent = people.stream()
                    .filter( person ->
                            person.getName().equals(currentParent) ||
                            person.getDate().equals(currentParent))
                    .findFirst().orElse(null);
            children.forEach(currentChild -> {
                Person child = people.stream()
                        .filter( person ->
                                person.getName().equals(currentChild) ||
                                person.getDate().equals(currentChild))
                        .findFirst().orElse(null);
                child.getParents().add(parent);
                parent.getChildren().add(child);
            });
        });
        Person personOfInterest = people.stream().filter( person -> {
            return person.getName().equals(startFrom) || person.getDate().equals(startFrom);
        }).findFirst().orElse(null);
        System.out.println(personOfInterest);
        System.out.println("Parents:");
        personOfInterest.getParents().forEach(System.out::println);
        System.out.println("Children:");
        personOfInterest.getChildren().forEach(System.out::println);

    }

    public static boolean isDate(String s) {
        for (char c : s.toCharArray())
            if (c == '/') return true;
        return false;
    }
}
