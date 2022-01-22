package L02MultidimensionalArrays.Exercise.T12TheMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] matrix;
    private static int rows, cols;
    private static char startChar, fillChar;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] chr = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = chr[col].charAt(0);
            }
        }
        fillChar = reader.readLine().charAt(0);
        dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int fillRow = dimensions[0], fillCol = dimensions[1];
        startChar = matrix[fillRow][fillCol];
        fill(fillRow, fillCol);
        printMatrix();

    }

    private static void fill(int fillRow, int fillCol) {
        matrix[fillRow][fillCol] = fillChar;
        if(fillCol - 1 >= 0 && matrix[fillRow][fillCol - 1] == startChar) fill(fillRow, fillCol - 1);
        if(fillCol + 1 < cols && matrix[fillRow][fillCol + 1] == startChar) fill(fillRow, fillCol + 1);
        if(fillRow - 1 >= 0 && matrix[fillRow - 1][fillCol] == startChar) fill(fillRow - 1, fillCol);
        if(fillRow + 1 < rows && matrix[fillRow + 1][fillCol] == startChar) fill(fillRow + 1, fillCol);
    }

    private static void printMatrix() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
