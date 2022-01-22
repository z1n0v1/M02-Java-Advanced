/*
    https://judge.softuni.org/Contests/Compete/Index/1460#3

    04. Maximal Sum

Write a program that reads a rectangular integer matrix of size N x M
and finds in it the square 3 x 3 that has maximal sum of its elements.

Input
•	On the first line, you will receive the rows N and columns M.
•	On the next N lines you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below:
 */

package L02MultidimensionalArrays.Exercise.T04MaximalSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = data[0], cols = data[1];
        matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSubMatrixIndexRow = 0, maxSubMatrixIndexCol = 0, maxSum = 0;
        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {
                int sum = getSum(row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxSubMatrixIndexCol = col;
                    maxSubMatrixIndexRow = row;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printSubMatrix(maxSubMatrixIndexRow, maxSubMatrixIndexCol);
    }

    private static void printSubMatrix(int maxSubMatrixIndexRow, int maxSubMatrixIndexCol) {
        for (int row = maxSubMatrixIndexRow; row < maxSubMatrixIndexRow + 3; row++) {
            for (int col = maxSubMatrixIndexCol; col < maxSubMatrixIndexCol + 3; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int getSum(int startingRow, int startingCol) {
        int sum = 0;
        for (int row = startingRow; row < startingRow + 3; row++) {
            for (int col = startingCol; col < startingCol + 3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

}
