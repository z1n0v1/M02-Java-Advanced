package L03SetsAndMapsAdvanced.Exercise.T04CountSymbols;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (char sym: scanner.nextLine().toCharArray()) {
            if(!symbols.containsKey(sym))
                symbols.put(sym, 1);
            else symbols.put(sym, symbols.get(sym) + 1);
        }
        symbols.forEach((symbol, num) -> System.out.printf("%c: %d time/s%n", symbol, num));
    }
}
