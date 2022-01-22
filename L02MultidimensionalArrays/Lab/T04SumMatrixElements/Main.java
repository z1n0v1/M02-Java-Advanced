/*
    https://judge.softuni.org/Contests/Practice/Index/1459#3

    04. Sum Matrix Elements

Write a program that reads a matrix from the console and prints:
•	The count of rows
•	The count of columns
•	The sum of all matrix’s elements

On the first line you will get the dimensions of the matrix in format {rows, columns}.
On the next lines you will get the elements for each row separated with a coma.
 */

package L02MultidimensionalArrays.Lab.T04SumMatrixElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(dimensions[0]);
        System.out.println(dimensions[1]);

        int[][] matrix = new int[dimensions[0]][];
        int sum = 0;
        for (int cols = 0; cols < dimensions[0]; cols++) {
            matrix[cols] = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col : matrix[cols])
                sum += col;
        }
        System.out.println(sum);
    }
}
