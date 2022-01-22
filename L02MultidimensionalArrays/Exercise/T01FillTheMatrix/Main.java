/*
    https://judge.softuni.org/Contests/Compete/Index/1460#0

    01. Fill the Matrix

Filling a matrix in the regular way (top to bottom and left to right) is boring.
Write two methods that fill a matrix of size N x N in two different patterns. Both patterns are described below:

    A:           B:
 1 5  9 13    1 8  9 16
 2 6 10 14    2 7 10 15
 3 7 11 15    3 6 11 14
 4 8 12 16    4 5 12 13
 */

package L02MultidimensionalArrays.Exercise.T01FillTheMatrix;

import java.util.Scanner;

public class Main {
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = rows;
        matrix = new int[rows][cols];
        if(data[1].equals("A")) {
            generateMatrixA(rows, cols);
        } else {
            generateMatrixB(rows, cols);
        }
        printMatrix();

    }

    private static void generateMatrixB(int rows, int cols) {
        int value = 1;
        for (int col = 0; col < cols; col++) {
            if (((col) % 2) == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = value;
                    value++;
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }
        }
    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void generateMatrixA(int rows, int cols) {
        int value = 1;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = value;
                value++;
            }
        }
    }
}
