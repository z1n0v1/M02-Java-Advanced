package L03SetsAndMapsAdvanced.Lab.T01ParkingLot;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(", ");

            if (command[0].equals("IN"))
                parking.add(command[1]);
            else parking.remove(command[1]);

            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String num : parking)
                System.out.println(num);
        }
    }
}
