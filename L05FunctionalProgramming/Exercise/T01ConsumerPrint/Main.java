package L05FunctionalProgramming.Exercise.T01ConsumerPrint;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        Consumer<String> print = System.out::println;
        for (String s : strings)
            print.accept(s);

    }
}
