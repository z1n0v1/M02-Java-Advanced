/*
    https://judge.softuni.org/Contests/Practice/Index/1459#0

    01. Compare Matrices

Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element.
For better code reusability, you could do the comparison in a method, which returns true if they are equal and false if not.

Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix
and C – the number of columns – followed by R lines containing the C numbers,
separated by spaces (each line will have an equal amount of numbers.

The matrices will have at most 10 rows and at most 10 columns.

Print equal if the matrices match, and not equal if they don’t match.
 */

package L02MultidimensionalArrays.Lab.T01CompareMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstMatrixData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = new int[firstMatrixData[0]][];

        for (int i = 0; i < firstMatrixData[0]; i++) {
            firstMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] secondMatrixData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] secondMatrix = new int[secondMatrixData[0]][];

        for (int i = 0; i < secondMatrixData[0]; i++) {
            secondMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        boolean equal = true;
        if (firstMatrixData[0] != secondMatrixData[0]
                || firstMatrixData[1] != secondMatrixData[1])
            equal = false;
        if(!equal) System.out.println("not equal");
        else {
            if(compare(firstMatrix, secondMatrix))
                System.out.println("equal");
            else System.out.println("not equal");
        }

    }

    private static boolean compare(int[][] firstMatrix, int[][] secondMatrix) {

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if( firstMatrix[i][j] != secondMatrix[i][j])
                    return false;
            }
        }
        return true;
    }
}
