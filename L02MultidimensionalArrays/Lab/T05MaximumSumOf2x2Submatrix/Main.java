/*
    https://judge.softuni.org/Contests/Practice/Index/1459#4

    05. Maximum Sum of 2x2 Submatrix

Write a program that reads a matrix from the console.
Then find the biggest sum of a 2x2 submatrix. Print the submatrix and its sum.

On the first line you will get the dimensions of the matrix in format {rows, columns}.
On the next lines you will get the elements for each row separated with a coma.
 */

package L02MultidimensionalArrays.Lab.T05MaximumSumOf2x2Submatrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][];

        int subMatrixColIndex = -1, subMatrixRowIndex = -1, maxSum = Integer.MIN_VALUE;

        for (int col = 0; col < dimensions[0]; col++) {
            matrix[col] = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        for (int col = 0; col < dimensions[0] - 1; col++) {
            for (int row = 0; row < dimensions[1] - 1; row++) {
                int sum = matrix[col][row] + matrix[col][row + 1]
                        + matrix[col + 1][row] + matrix[col + 1][row + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    subMatrixColIndex = col;
                    subMatrixRowIndex = row;
                }
            }
        }
        System.out.printf("%d %d%n%d %d%n", matrix[subMatrixColIndex][subMatrixRowIndex],
                matrix[subMatrixColIndex][subMatrixRowIndex + 1],
                matrix[subMatrixColIndex + 1][subMatrixRowIndex],
                matrix[subMatrixColIndex + 1][subMatrixRowIndex + 1]);
        System.out.println(maxSum);
    }
}
