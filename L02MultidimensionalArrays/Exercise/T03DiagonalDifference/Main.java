/*
    https://judge.softuni.org/Contests/Compete/Index/1460#2

    03. Diagonal Difference

Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).

Input
•	The first line holds a number n – the size of matrix.
•	The next n lines hold the values for every row – n numbers separated by a space.

Hints
•	Use a single loop i = [1 … n] to sum the diagonals.
•	The primary diagonal holds all cells {row, col} where row == col == i.
•	The secondary diagonal holds all cells {row, col} where row == i and col == n-1-i.
 */

package L02MultidimensionalArrays.Exercise.T03DiagonalDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        readMatrix(dimensions, scanner);

        System.out.println(calculateSum(dimensions));
    }

    private static int calculateSum(int dimensions) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < dimensions; i++) {
            leftSum += matrix[i][i];
            rightSum += matrix[i][dimensions - 1 - i];
        }
        return Math.abs(leftSum - rightSum);
    }

    private static void readMatrix(int dimensions, Scanner scanner) {
        matrix = new int[dimensions][];
        for (int row = 0; row < dimensions; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
