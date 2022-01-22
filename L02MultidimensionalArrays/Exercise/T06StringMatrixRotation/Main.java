package L02MultidimensionalArrays.Exercise.T06StringMatrixRotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("Rotate\\((?<degrees>[0-9]+)\\)");
        Matcher matcher = pattern.matcher(input);
//        System.out.println(matcher.group(0));
        matcher.find();
        int degrees = Integer.parseInt(matcher.group("degrees"));

//        int degrees = Integer.parseInt(
//                Pattern.compile("Rotate\\((?<degrees>[0-9]+)\\)")
//                        .matcher(scanner.nextLine()).find()
//                        .group("degrees"));
        int rotation = degrees / 90;
        List<String> strings = new ArrayList<>();
        int maxLength = 0;
        input = scanner.nextLine();

        while (!input.equals("END")) {
            if (input.length() > maxLength)
                maxLength = input.length();
            strings.add(input);
            input = scanner.nextLine();
        }

        matrix = new char[strings.size()][];
        for (int i = 0; i < strings.size(); i++) {
            matrix[i] = new char[maxLength];
            String s = strings.get(i);
            for (int j = 0; j < s.length(); j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        switch (rotation % 4) {
            case 0: {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[0].length; col++) {
                        if (matrix[row][col] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%c", matrix[row][col]);
                        }
                    }
                    System.out.println();
                }
                break;
            }
            case 1: {
                {
                    for (int col = 0; col < matrix[0].length; col++) {
                        for (int row = matrix.length - 1; row >= 0; row--) {
                            if (matrix[row][col] == 0) {
                                System.out.print(" ");
                            } else {
                                System.out.printf("%c", matrix[row][col]);
                            }
                        }
                        System.out.println();
                    }
                }
                break;
            }
            case 2: {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = matrix[0].length - 1; col >= 0; col--) {
                        if (matrix[row][col] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%c", matrix[row][col]);
                        }
                    }
                    System.out.println();
                }
                break;
            }
            case 3: {
                for (int col = matrix[0].length - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.length; row++) {
                        if (matrix[row][col] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%c", matrix[row][col]);
                        }
                    }
                    System.out.println();
                }
                break;
            }
        }

    }
}
