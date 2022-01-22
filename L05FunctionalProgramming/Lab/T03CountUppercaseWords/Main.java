package L05FunctionalProgramming.Lab.T03CountUppercaseWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        List<String> words = new ArrayList<>();
        int count = 0;
        for (String word : input) {
            if(isUpperCase.test(word)) {
                words.add(word);
                count++;
            }
        }
        System.out.println(count);
        for (String word : words)
            System.out.println(word);
    }
}
