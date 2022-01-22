package L07Generics.Exercise.T07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Add":
                    String element = token[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(token[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    System.out.println(list.contains(token[1]));
                    break;
                case "Swap":
                    int leftIndex = Integer.parseInt(token[1]);
                    int rightIndex = Integer.parseInt(token[2]);
                    list.swap(leftIndex, rightIndex);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(token[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (String e : list)
                        System.out.println(e);
                    break;
            }
        }
    }
}
