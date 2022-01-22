package L03SetsAndMapsAdvanced.Exercise.T07FixEmails;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com"))
                emails.put(input, email);
            input = scanner.nextLine();
        }
        emails.forEach((name, email) -> System.out.printf("%s -> %s%n", name, email));
    }
}
