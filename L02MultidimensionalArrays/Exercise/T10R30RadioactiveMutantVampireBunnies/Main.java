package L02MultidimensionalArrays.Exercise.T10R30RadioactiveMutantVampireBunnies;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] lair;
    static int playerRow, playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        lair = new char[dimensions[0]][dimensions[1]];
        for (int row = 0; row < dimensions[0]; row++) {
            lair[row] = scanner.nextLine().toCharArray();
        }
        getPlayerCoordinates();

        char[] commands = scanner.nextLine().toCharArray();
        boolean end = false;
        for (char command : commands) {
            switch (command) {
                case 'L': {
                    if (playerCol - 1 < 0) {
                        deathByBunny();
                        endGame(true);
                        end = true;
                    } else if (lair[playerRow][playerCol - 1] == 'B') {
                        deathByBunny();
                        playerCol--;
                        endGame(false);
                        end = true;
                    } else {
                        lair[playerRow][playerCol] = '.';
                        lair[playerRow][playerCol - 1] = 'P';
                        playerCol--;
                    }
                    break;
                }
                case 'R': {
                    if (playerCol + 1 == lair[0].length) {
                        deathByBunny();
//                        playerCol++;
                        endGame(true);
                        end = true;
                    } else if (lair[playerRow][playerCol + 1] == 'B') {
                        deathByBunny();
                        playerCol++;
                        endGame(false);
                        end = true;
                    } else {
                        lair[playerRow][playerCol] = '.';
                        lair[playerRow][playerCol - 1] = 'P';
                        playerCol++;
                    }
                    break;
                }
                case 'U': {
                    if (playerRow - 1 < 0) {
                        deathByBunny();
                        endGame(true);
                        end = true;
                    } else if (lair[playerRow - 1][playerCol] == 'B') {
                        deathByBunny();
                        playerRow--;
                        endGame(false);
                        end = true;
                    } else {
                        lair[playerRow][playerCol] = '.';
                        lair[playerRow - 1][playerCol] = 'P';
                        playerRow--;
                    }
                    break;
                }
                case 'D': {
                    if (playerRow == lair.length) {
                        deathByBunny();
                        endGame(true);
                        end = true;
                    } else if (lair[playerRow + 1][playerCol] == 'B') {
                        deathByBunny();
                        playerRow++;
                        endGame(false);
                        end = true;
                    } else {
                        lair[playerRow][playerCol] = '.';
                        lair[playerRow + 1][playerCol] = 'P';
                        playerRow++;
                    }
                    break;
                }
            }
            if (end) break;
            if (deathByBunny()) break;
        }


    }

    private static boolean deathByBunny() {
        boolean playerDeath = false;
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[0].length; col++) {
                if (lair[row][col] == 'B') {
//                    if ( // bunny kills player
//                            (row > 0 && lair[row - 1][col] == 'P') ||
//                                    (col > 0 && lair[row][col - 1] == 'P') ||
//                                    (row + 1 < lair.length && lair[row + 1][col] == 'P') ||
//                                    (col + 1 < lair[0].length && lair[row][col + 1] == 'P')
//                    ) {
//                        if ( // bunny kills player
                    if (row > 0 && lair[row - 1][col] == 'P') {
                        lair[row - 1][col] = 'b';
//                        playerRow--;
                        playerDeath = true;
                    } else if
                    (col > 0 && lair[row][col - 1] == 'P') {
                        lair[row][col - 1] = 'b';
//                        playerCol--;
                        playerDeath = true;
                    } else if
                    (row + 1 < lair.length && lair[row + 1][col] == 'P') {
                        lair[row + 1][col] = 'b';
//                        playerRow++;
                        playerDeath = true;
                    } else if (col + 1 < lair[0].length && lair[row][col + 1] == 'P') {
                        lair[row][col + 1] = 'b';
//                        playerCol++;
                        playerDeath = true;
//                    }
//                        )
//                    {
//                        playerDeath = true;
//                        deathByBunny();
//                        endGame(false);
//                        return true;
                    }
//                    else{
                        if ((row > 0 && lair[row - 1][col] == '.')) lair[row - 1][col] = 'b';
                        if (col > 0 && lair[row][col - 1] == '.') lair[row][col - 1] = 'b';
                        if (row + 1 < lair.length && lair[row + 1][col] == '.') lair[row + 1][col] = 'b';
                        if (col + 1 < lair[0].length && lair[row][col + 1] == '.') lair[row][col + 1] = 'b';
//                    }
                }
            }
        }

        bunnyToBunny();
        return playerDeath;
    }

    private static void bunnyToBunny() {
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[0].length; col++) {
                if (lair[row][col] == 'b') lair[row][col] = 'B';
            }
        }
    }

    private static void endGame(boolean won) {
        if (won) lair[playerRow][playerCol] = '.';
        else lair[playerRow][playerCol] = 'B';
        for (char[] row : lair) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
        if (won)
            System.out.printf("won: %d %d%n", playerRow, playerCol);
        else System.out.printf("dead: %d %d%n", playerRow, playerCol);
    }

    private static void getPlayerCoordinates() {
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[0].length; col++) {
                if (lair[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}
