/*
    https://judge.softuni.org/Contests/Practice/Index/1459#6

    07. Find The Real Queen

Write a program that reads (8 x 8) matrix of characters from the console.
The matrix represents a chess board with figures on it. The figures can be - queens as char 'q' or any other ASCII symbol.
There will be more than one queen but only one queen will have valid position,
which is not attacked from any other queen and does not attack any other queen.
In other word in the way of the valid queen there are no other queens, but there may be any other ASCII symbol.
Your task is to read the chessboard and find the position of the valid queen.
According to chess rules the queen can attack all the cells in horizontal vertical
and both diagonals which cross the queen position.
 */

package L02MultidimensionalArrays.Lab.T07FindTheRealQueen;

import java.util.Scanner;

public class Main {
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrix = new char[8][8];
        readMatrix(scanner);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'q' && isRealQueen(row, col)) {
                    System.out.printf("%d %d", row, col);
                }
            }
        }
    }

    private static boolean isRealQueen(int row, int col) {

        for (int i = 0; i < 8; i++) {
            if (i == col) continue;
            if (matrix[row][i] == 'q')
                return false;
        }
        for (int i = 0; i < 8; i++) {
            if (i == row) continue;
            if (matrix[i][col] == 'q')
                return false;
        }
        int curRow = row - 1, curCol = col - 1;
        while (curRow >= 0 && curCol >= 0) {
            if(matrix[curRow][curCol] == 'q')
                return false;
            curRow--;
            curCol--;
        }
        curRow = row + 1;
        curCol = col + 1;
        while (curRow < 8 && curCol < 8) {
            if(matrix[curRow][curCol] == 'q')
                return false;
            curRow++;
            curCol++;
        }
        curRow = row + 1;
        curCol = col - 1;
        while (curRow < 8 && curCol >= 0) {
            if(matrix[curRow][curCol] == 'q')
                return false;
            curRow++;
            curCol--;
        }
        curRow = row - 1;
        curCol = col + 1;
        while (curRow >= 0 && curCol < 8) {
            if(matrix[curRow][curCol] == 'q')
                return false;
            curRow--;
            curCol++;
        }
        return true;
    }

    private static void readMatrix(Scanner scanner) {
        for (int row = 0; row < 8; row++) {
            String[] cols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < 8; col++) {
                matrix[row][col] = cols[col].charAt(0);
            }
        }
    }
}
