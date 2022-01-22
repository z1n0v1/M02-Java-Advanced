package L02MultidimensionalArrays.Exercise.T10T3RadioactiveMutantVampireBunnies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] lair;
    private static int rows, cols;
    private static int playerRow, playerCol;
    private static boolean hasWon, isDead;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        hasWon = false;
        isDead = false;

        lair = new char[rows][];
        for (int i = 0; i < rows; i++)
            lair[i] = reader.readLine().toCharArray();

        findPlayer();

        for (char move : reader.readLine().toCharArray()) {
            switch (move) {
                case 'R':
                    if (playerCol + 1 >= cols) {
                        hasWon = true;
                        lair[playerRow][playerCol] = '.';
                        break;
                    }
                    if (lair[playerRow][playerCol + 1] == 'B') {
                        lair[playerRow][playerCol] = '.';
                        playerCol++;
                        isDead = true;
                        break;
                    }
                    lair[playerRow][playerCol] = '.';
                    playerCol++;
                    lair[playerRow][playerCol] = 'P';
                    break;
                case 'L':
                    if (playerCol - 1 < 0) {
                        hasWon = true;
                        lair[playerRow][playerCol] = '.';
                        break;
                    }
                    if (lair[playerRow][playerCol - 1] == 'B') {
                        lair[playerRow][playerCol] = '.';
                        playerCol--;
                        isDead = true;
                        break;
                    }
                    lair[playerRow][playerCol] = '.';
                    playerCol--;
                    lair[playerRow][playerCol] = 'P';
                    break;
                case 'U':
                    if(playerRow - 1 < 0) {
                        hasWon = true;
                        lair[playerRow][playerCol] = '.';
                        break;
                    }
                    if(lair[playerRow - 1][playerCol] == 'B') {
                        lair[playerRow][playerCol] = '.';
                        playerRow--;
                        isDead = true;
                        break;
                    }
                    lair[playerRow][playerCol] = '.';
                    playerRow--;
                    lair[playerRow][playerCol] = 'P';
                    break;
                case 'D':
                    if(playerRow + 1 >= rows) {
                        hasWon = true;
                        lair[playerRow][playerCol] = '.';
                        break;
                    }
                    if(lair[playerRow][playerCol + 1] == 'B') {
                        lair[playerRow][playerCol] = '.';
                        playerRow++;
                        isDead = true;
                        break;
                    }
                    lair[playerRow][playerCol] = '.';
                    playerRow++;
                    lair[playerRow][playerCol] = 'P';
                    break;
            }
            spreadBunnies();
            //playerRow == 6 && playerCol == 9
            /*
            System.out.printf("p(%d,%d)-%c%n", playerRow, playerCol, move);
            printLair();
            spreadBunnies();
            System.out.printf("b(%d,%d)-%c%n", playerRow, playerCol, move);
            printLair();
            System.out.println("---");
//            */
            if(isDead || hasWon) break;
        }
        printLair();
        if(isDead) {
            System.out.print("dead: ");
        } else {
            System.out.printf("won: ");
        }
        System.out.printf("%d %d", playerRow, playerCol);
    }

    private static void printLair() {
        for (char[] row : lair) {
            for (char col : row)
                System.out.print(col);
            System.out.println();
        }

    }

    private static void spreadBunnies() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (lair[row][col] == 'B') {
                    if (row - 1 >= 0 && lair[row - 1][col] == '.')
                        lair[row - 1][col] = 'b';
                    if (row + 1 < rows && lair[row + 1][col] == '.')
                        lair[row + 1][col] = 'b';
                    if (col - 1 >= 0 && lair[row][col - 1] == '.')
                        lair[row][col - 1] = 'b';
                    if (col + 1 < cols && lair[row][col + 1] == '.')
                        lair[row][col + 1] = 'b';

                    if (row - 1 >= 0 && lair[row - 1][col] == 'P') {
                        lair[row - 1][col] = 'b';
                        isDead = true;
                    }
                    if (row + 1 < rows && lair[row + 1][col] == 'P') {
                        lair[row + 1][col] = 'b';
                        isDead = true;
                    }
                    if (col - 1 >= 0 && lair[row][col - 1] == 'P') {
                        lair[row][col - 1] = 'b';
                        isDead = true;
                    }
                    if (col + 1 < cols && lair[row][col + 1] == 'P') {
                        lair[row][col + 1] = 'b';
                        isDead = true;
                    }
                }
            }

         }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(lair[row][col] == 'b')
                    lair[row][col] = 'B';
            }
        }
    }

    private static void findPlayer() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (lair[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    return;
                }

            }
        }
    }
}

/*
инпут:

8 11
...........
...........
.....B.....
...........
...........
....B.....P
...........
..B........
LDRR

...BBBBB...
..BBBBBBB..
.BBBBBBBBB.
..BBBBBBB..
.BBBBBBB...
BBBBBBBBB..
BBBBBBBB...
BBBBBBB....
won: 6 10

3 3
..B
...
P..
UUU

BBB
.BB
..B
dead: 0 0

 */