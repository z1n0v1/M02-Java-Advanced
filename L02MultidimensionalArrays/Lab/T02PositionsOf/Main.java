/*
    https://judge.softuni.org/Contests/Practice/Index/1459#1

    02. Positions Of

Write a program that reads a matrix of integers from the console,
then a number and prints all the positions at which that number appears in the matrix.

The matrix definition on the console will contain a line with two positive integer numbers R and C –
the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
representing each row of the matrix.

The number you will need to find the positions of will be entered on a single line, after the matrix.

You should print each position on a single line – first print the row, then the column at which the number appears.

If the number does not appear in the matrix, print not found
 */

package L02MultidimensionalArrays.Lab.T02PositionsOf;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixRowCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixRowCol[0]][];
        for (int i = 0; i < matrix.length; i++)
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numToFind = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == numToFind) {
                    found = true;
                    System.out.printf("%d %d%n", i, j);
                }
            }
        }
        if(!found) System.out.println("not found");
    }
}
