package L03SetsAndMapsAdvanced.Exercise.T05Phonebook;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {

            String[] data = input.split("\\-");
            phonebook.put(data[0], data[1]);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if(!phonebook.containsKey(input))
                System.out.printf("Contact %s does not exist.%n", input);
            else System.out.printf("%s -> %s%n", input, phonebook.get(input));

            input = scanner.nextLine();
        }
    }
}
