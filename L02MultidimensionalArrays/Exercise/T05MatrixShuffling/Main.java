/*
    https://judge.softuni.org/Contests/Compete/Index/1460#4

    05. Matrix shuffling

Write a program which reads a string matrix from the console and performs certain operations with its elements.
User input is provided in a similar way like in the problems above – first you read the dimensions and then the data.

Your program should then receive commands in format: "swap row1 col1 row2c col2"
where row1, row2, col1, col2 are coordinates in the matrix. In order for a command to be valid,
it should start with the "swap" keyword along with four valid coordinates (no more, no less).
You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2])
and print the matrix at each step (thus you'll be able to check if the operation was performed correctly).

If the command is not valid (doesn't contain the keyword "swap",
has fewer or more coordinates entered or the given coordinates do not exist), print "Invalid input!"
and move on to the next command. Your program should finish when the string "END" is entered.

Hints
•	Think about Exception Handling
 */

package L02MultidimensionalArrays.Exercise.T05MatrixShuffling;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int length = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[length][];

        for (int row = 0; row < length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (command.length != 5 || !command[0].equals("swap")
                    || !isNumber(command[1]) || !isNumber(command[2])
                    || !isNumber(command[3]) || !isNumber(command[4])) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0
                        || row1 >= length || col1 >= width || row2 >= length || col2 >= width) {
                    System.out.println("Invalid input!");
                } else {
                    int temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);
                }
            }

            input = scanner.nextLine();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}
