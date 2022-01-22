package L08IteratorsAndComparators.Exercise.T03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IntStack intStack = new IntStack();

//        for (String element : Arrays.stream(scanner.nextLine().split(" ")).skip(1)
//                .toArray(String[]::new)
//        )
//            intStack.push(Integer.parseInt(element.replaceAll(",", "")));


        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split(" ");
            switch (data[0]) {
                case "Pop":
                    intStack.pop();
                    break;
                case "Push":
                    for (int i = 1; i < data.length; i++) {
                        intStack.push(Integer.parseInt(data[i].replaceAll(",", "")));
                    }
                    break;
            }

        }
        for (int element : intStack)
            System.out.println(element);
        for (int element : intStack)
            System.out.println(element);
    }
}
