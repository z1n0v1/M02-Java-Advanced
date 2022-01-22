package L03SetsAndMapsAdvanced.Lab.T02SoftUniParty;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();
        TreeSet<String> vip = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if(Character.isDigit(input.charAt(0)))
                vip.add(input);
            else guests.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            if(Character.isDigit(input.charAt(0)))
                vip.remove(input);
            else guests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(guests.size() + vip.size());
        for (String guest : vip) {
            System.out.println(guest);
//            missingGuests++;
        }
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
