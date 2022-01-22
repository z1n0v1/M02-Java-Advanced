package L05FunctionalProgramming.Exercise.T02KnightsOfHonor;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String> print = name -> System.out.println("Sir " + name);
        for (String name : names)
            print.accept(name);
    }
}
