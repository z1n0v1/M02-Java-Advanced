package L02MultidimensionalArrays.Exercise.T10T2R80RadioactiveMutantVampireBunnies;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] lair;
    static int playerRow, playerCol, rows, cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        lair = new char[rows][];
        for (int row = 0; row < rows; row++)
            lair[row] = scanner.nextLine().toCharArray();
        findPlayer();
//        printLair();

        char[] commands = scanner.nextLine().toCharArray();
        for (char command : commands) {
            if (!playerTurn(command)) break;
            if (multiplyBunnies()) {
                printLair();
                System.out.printf("dead: %d, %d%n", playerRow, playerCol);
                break;
            }
        }
    }

    private static boolean multiplyBunnies() {
        boolean isPlayerKilled = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (lair[row][col] == 'B') {
                    if (row - 1 >= 0) { // up
                        if (lair[row - 1][col] == 'P')
                            isPlayerKilled = true;
                        if (lair[row - 1][col] == '.')
                            lair[row - 1][col] = 'b';
                    }
                    if (row + 1 < rows) { // down
                        if (lair[row + 1][col] == 'P')
                            isPlayerKilled = true;
                        if (lair[row + 1][col] == '.')
                            lair[row + 1][col] = 'b';
                    }
                    if (col - 1 >= 0) { // left
                        if (lair[row][col - 1] == 'P')
                            isPlayerKilled = true;
                        if (lair[row][col - 1] == '.')
                            lair[row][col - 1] = 'b';
                    }
                    if (col + 1 < cols) { // right
                        if (lair[row][col + 1] == 'P')
                            isPlayerKilled = true;
                        if (lair[row][col + 1] == '.')
                            lair[row][col + 1] = 'b';
                    }
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (lair[row][col] == 'b')
                    lair[row][col] = 'B';
            }
        }
//        if(isPlayerKilled) lair[playerRow][playerCol] = 'B';
        return isPlayerKilled;
    }

    private static boolean playerTurn(char command) {
        switch (command) {
            case 'L': {
                if (playerCol - 1 < 0) {
                    lair[playerRow][playerCol] = '.';
                    multiplyBunnies();
                    printLair();
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    return false;
                } else if (lair[playerRow][playerCol - 1] == 'B') {
                    lair[playerRow][playerCol] = '.';
                    playerCol--;
                    multiplyBunnies();
                    printLair();
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    return false;
                } else {
                    lair[playerRow][playerCol] = '.';
                    lair[playerRow][playerCol - 1] = 'P';
                    playerCol--;
                }

                break;
            }
            case 'R': {
                if (playerCol + 1 >= cols) {
                    lair[playerRow][playerCol] = '.';
                    multiplyBunnies();
                    printLair();
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    return false;
                } else if (lair[playerRow][playerCol + 1] == 'B') {
                    lair[playerRow][playerCol] = '.';
                    playerCol++;
                    multiplyBunnies();
                    printLair();
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    return false;
                } else {
                    lair[playerRow][playerCol] = '.';
                    lair[playerRow][playerCol + 1] = 'P';
                    playerCol++;
                }

                break;
            }
            case 'U': {
                if (playerRow - 1 < 0) {
                    lair[playerRow][playerCol] = '.';
                    multiplyBunnies();
                    printLair();
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    return false;
                } else if (lair[playerRow - 1][playerCol] == 'B') {
                    lair[playerRow][playerCol] = '.';
                    playerRow--;
                    multiplyBunnies();
                    printLair();
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    return false;
                } else {
                    lair[playerRow][playerCol] = '.';
                    lair[playerRow - 1][playerCol] = 'P';
                    playerRow--;
                }

                break;
            }
            case 'D': {
                if (playerRow + 1 >= rows) {
                    lair[playerRow][playerCol] = '.';
                    multiplyBunnies();
                    printLair();
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    return false;
                } else if (lair[playerRow + 1][playerCol] == 'B') {
                    lair[playerRow][playerCol] = '.';
                    playerRow++;
                    multiplyBunnies();
                    printLair();
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    return false;
                } else {
                    lair[playerRow][playerCol] = '.';
                    lair[playerRow + 1][playerCol] = 'P';
                    playerRow++;
                }
                break;
            }
        }
        return true;
    }

    private static void printLair() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(lair[row][col]);
            }
            System.out.println();
        }
    }

    private static void findPlayer() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (lair[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }
    }
}
