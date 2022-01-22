/*
    https://judge.softuni.org/Contests/Practice/Index/1459#5

    06. Print Diagonals of Square Matrix

Write a program that reads a matrix from the console. Then print the diagonals.
The matrix will always be square. On the first line you read a single integer N the matrix size.
Then on each line N elements. The first diagonal should always start with the element at the first row and col,
the second diagonal should start with the element at the last row and first col.
 */

package L02MultidimensionalArrays.Lab.T06PrintDiagonalsOfSquareMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][];
        for (int col = 0; col < dimensions; col++) {
            matrix[col] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        for (int diag = 0; diag < matrix.length; diag++) {
            System.out.printf("%d ", matrix[diag][diag]);
        }
        System.out.println();
        for (int diag = 0; diag < matrix.length; diag++) {
            System.out.printf("%d ", matrix[dimensions - diag -1][diag]);
        }
    }
}
