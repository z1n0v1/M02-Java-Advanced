package L02MultidimensionalArrays.Exercise.T09ParkingSystem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[][] parkingLot;
    static int rows, cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];
        parkingLot = new boolean[rows][cols];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = data[0], targetRow = data[1], targetCol = data[2];

            int freeCol = getFreeCol(entryRow, targetRow, targetCol);

            if (freeCol == -1) {
                System.out.printf("Row %d full%n", targetRow);
            } else {
                if ( targetCol > 0 && !parkingLot[targetRow][targetCol]) {
                    int distance = Math.abs(entryRow - targetRow) + freeCol + 1;
                    System.out.println(distance);
                    parkingLot[targetRow][freeCol] = true;
                } else {
//                    int firstFreeCol = getFreeCol(entryRow, targetRow, targetCol);
                    int distance = Math.abs(entryRow - targetRow) + freeCol + 1;
                    System.out.println(distance);
                    parkingLot[targetRow][freeCol] = true;
                }
            }

            input = scanner.nextLine();
        }
    }

    private static int getFreeCol(int entryRow, int targetRow, int targetCol) {

//        int freeCol = -1;

        for (int i = 0; i < cols; i++) {
       /*     if ( targetCol - i >= 0 && !parkingLot[targetRow][targetCol - i]
                    && targetCol + i < parkingLot[0].length && !parkingLot[targetRow][targetCol + i]) {
                if (entryRow - targetCol < 0) {
                    freeCol = targetCol + i;
                    break;
                } else {
                    freeCol = targetCol - i;
                    break;
                }
            } else if (targetCol - i >= 0 && !parkingLot[targetRow][targetCol - i]) {
                freeCol = targetCol - i;
                break;
            } else if (targetCol + i < parkingLot[0].length && !parkingLot[targetRow][targetCol + i]) {
                freeCol = targetCol + i;
            }
        */
            if ( targetCol - i > 0 && targetCol + i > 0 && !parkingLot[targetRow][targetCol - i]
            && targetCol + i < cols && !parkingLot[targetRow][targetCol + i]) {
                if(entryRow - targetCol - i <= entryRow - targetCol + i) {
                    return targetCol - i;
                } else {
                    return targetCol + i;
                }
            } else if (targetCol - i > 0 && !parkingLot[targetRow][targetCol - i]) {
                return targetCol - i;
            } else if (targetCol + i > 0 && targetCol + i < cols && !parkingLot[targetRow][targetCol + i]) {
                return targetCol + i;
            }
        }


        return -1;
    }

    private static boolean isFull(int row) {
        for (int col = 1; col < parkingLot.length; col++) {
            if(!parkingLot[row][col]) return false;
        }
        return true;
    }
}
