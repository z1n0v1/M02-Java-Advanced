/*
    https://judge.softuni.org/Contests/Practice/Index/1459#7

    08. Wrong Measurements

You will be given the rows of a matrix. Then the matrix itself.
Inside this matrix there are mistaken values which need to be replaced you will receive the wrong value at the last line.
Those values should be replaced with the sum of the nearest elements in the four directions up, down, left and right,
but only if they are valid values. At the end you have to print the fixed measurements.
 */

package L02MultidimensionalArrays.Lab.T08WrongMeasurements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] matrix, resultingMatrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        readMatrix(rows, scanner);
        int cols = matrix[0].length;
        int[] wrongValueIndex = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueIndex[0]][wrongValueIndex[1]];

        resultingMatrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            resultingMatrix[row] = matrix[row].clone();
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] == wrongValue)
                    resultingMatrix[row][col] = computeSum(row, col, wrongValue);
            }
        }
        printMatrix();
    }

    private static void printMatrix() {
        for (int row = 0; row < resultingMatrix.length; row++) {
            for (int col = 0; col < resultingMatrix[0].length; col++) {
                System.out.printf("%d ", resultingMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int computeSum(int row, int col, int wrongValue) {
        int sum = 0;
        if(col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if(col + 1 < matrix[0].length && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if(row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if(row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        return sum;
    }

    private static void readMatrix(int rows, Scanner scanner) {
        matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
