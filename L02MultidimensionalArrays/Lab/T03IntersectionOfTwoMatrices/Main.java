/*
    https://judge.softuni.org/Contests/Practice/Index/1459#2

    03. Intersection of Two Matrices

Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N
and prints third matrix C[][] which is filled with the intersecting elements of A and B,
otherwise set the element to '*'. On the first two lines you receive M and N,
then on 2 * M lines N characters – the matrices elements.

The matrix elements may be any ASCII char except '*'.
 */

package L02MultidimensionalArrays.Lab.T03IntersectionOfTwoMatrices;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        readMatrix(firstMatrix);
        readMatrix(secondMatrix);

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if(firstMatrix[i][j] == secondMatrix[i][j])
                    System.out.printf("%c ", firstMatrix[i][j]);
                else System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            for (int j = 0; j < row.length; j++) {
                matrix[i][j]= row[j].charAt(0);
            }
        }
    }
}
