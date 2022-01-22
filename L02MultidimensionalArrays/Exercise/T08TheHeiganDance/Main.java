package L02MultidimensionalArrays.Exercise.T08TheHeiganDance;

import java.util.Scanner;

public class Main {
    static boolean[][] room = new boolean[15][15];
    static int playerRow = 7, playerCol = 7,
            playerHP = 18500;
    static double heiganHP = 3000000;
    static String lastAttack = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        boolean nextTurnPlague = false;
        while (true) {
            String[] attack = scanner.nextLine().split("\\s+");
            heiganHP -= damage;
//            if (playerIsDead()) break;
            if (nextTurnPlague) {
                playerHP -= 3500;
                nextTurnPlague = false;
                if (playerIsDead()) break;
            }
            if (heiganIsDead()) break;
            int row = Integer.parseInt(attack[1]), col = Integer.parseInt(attack[2]);
            splash(row, col);
            switch (attack[0]) {
                case "Cloud": {
                    if (isHit()) {
                        playerHP -= 3500;
                        nextTurnPlague = true;
                        lastAttack = "Plague Cloud";
                    }
                    break;
                }
                case "Eruption": {
                    if (isHit()) playerHP -= 6000;
                    lastAttack = "Eruption";
                    break;
                }
            }
            clear();
            if (playerIsDead()) break;
        }
    }

    private static boolean heiganIsDead() {
        if (heiganHP < 0) {
            System.out.println("Heigan: Defeated!");
            if(playerHP < 0) System.out.printf("Player: Killed by %s%n", lastAttack);
            else System.out.printf("Player: %d%n", playerHP);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return true;
        }
        return false;
    }

    private static boolean playerIsDead() {
        if (playerHP < 0) {
            if ( heiganHP < 0 ) System.out.println("Heigan: Defeated!");
            else System.out.printf("Heigan: %.2f%n", heiganHP);
            System.out.printf("Player: Killed by %s%n", lastAttack);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return true;
        }
        return false;
    }


    private static boolean isHit() {
        if (room[playerRow][playerCol]) {
            if (playerRow > 0 && playerRow < 15 && !room[playerRow - 1][playerCol])
                playerRow--; // move up
            else if (playerCol < 14 && !room[playerRow][playerCol + 1])
                playerCol++; // move right
            else if (playerRow < 14 && !room[playerRow + 1][playerCol])
                playerRow++; // move down
            else if (playerCol > 0 && playerRow < 15 && !room[playerRow][playerCol - 1])
                playerCol--; // move left
            else return true;
        }
        return false;
    }

    private static void splash(int row, int col) {
        for (int currentRow = row - 1; currentRow <= row + 1; currentRow++) {
            for (int currentCol = col - 1; currentCol <= col + 1; currentCol++) {
                if (currentRow >= 0 && currentRow < 15
                        && currentCol >= 0 && currentCol < 15)
                    room[currentRow][currentCol] = true;
            }
        }
    }

    private static void clear() {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                room[row][col] = false;
            }
        }
    }
}
