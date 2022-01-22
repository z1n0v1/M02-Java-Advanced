/*
    https://judge.softuni.org/Contests/Compete/Index/1460#1

    02. Matrix of Palindromes

Write a program to generate the following matrix of palindromes
of 3 letters with r rows and c columns like the one in the examples below.
•	Rows define the first and the last letter: row 0  ‘a’, row 1  ‘b’, row 2  ‘c’, …
•	Columns + rows define the middle letter:
o	column 0, row 0  ‘a’, column 1, row 0  ‘b’, column 2, row 0  ‘c’, …
o	column 0, row 1  ‘b’, column 1, row 1  ‘c’, column 2, row 1  ‘d’, …

Input
•	The numbers r and c stay at the first line at the input.
•	 r and c are integers in the range [1…26].
•	 r + c ≤ 27

Hints
•	Use two nested loops to generate the matrix.
•	Print the matrix row by row in a loop.
•	Don’t forget to pack everything in methods.
 */

package L02MultidimensionalArrays.Exercise.T02MatrixOfPalindromes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        matrix = new String[rows][cols];

        generateMatrix(rows,cols);

        printMatrix();

    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void generateMatrix(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                StringBuilder element = new StringBuilder();
                element.append((char)( 'a' + row));
                element.append((char)( 'a' + col + row));
                element.append((char)( 'a' + row));
                matrix[row][col] = element.toString();
            }
        }
    }
}
