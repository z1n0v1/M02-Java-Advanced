package L03SetsAndMapsAdvanced.Exercise.T01UniqueUsernames;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) usernames.add(scanner.nextLine());

        usernames.forEach(System.out::println);
    }
}
