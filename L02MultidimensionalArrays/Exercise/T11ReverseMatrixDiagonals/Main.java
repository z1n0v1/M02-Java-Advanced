package L02MultidimensionalArrays.Exercise.T11ReverseMatrixDiagonals;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int rows, cols;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        matrix = new int[rows][];
        for (int row = 0; row < rows; row++)
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int col = cols - 1; col >= 0; col--) {
            printDiagonal(rows - 1, col);
        }
        for (int row = rows - 2; row >= 0 ; row--) {
            printDiagonal(row, 0);
        }

    }

    private static void printDiagonal(int row, int col) {
        while (row >= 0 && col < cols ) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
        System.out.println();
    }
}
