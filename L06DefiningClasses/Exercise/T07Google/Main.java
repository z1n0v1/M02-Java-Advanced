package L06DefiningClasses.Exercise.T07Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            if (!people.containsKey(personName))
                people.put(personName, new Person(personName));
            switch (data[1]) {
                case "company": {
                    String companyName = data[2];
                    String department = data[3];
                    Double salary = Double.parseDouble(data[4]);
                    people.get(personName).setCompany(new Company(companyName, department, salary));
                    break;
                }
                case "pokemon": {
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    people.get(personName).addPokemon(new Pokemon(pokemonName, pokemonType));
                    break;
                }
                case "parents": {
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    people.get(personName).addParent(new Parent(parentName, parentBirthday));
                    break;
                }
                case "children": {
                    String childName = data[2];
                    String childBirthday = data[3];
                    people.get(personName).addChild(new Child(childName, childBirthday));
                    break;
                }
                case "car": {
                    String model = data[2];
                    String speed = data[3];
                    people.get(personName).setCar(new Car(model, speed));
                    break;
                }
            }

            input = scanner.nextLine();
        }
        System.out.println(people.get(scanner.nextLine()));

    }
}
