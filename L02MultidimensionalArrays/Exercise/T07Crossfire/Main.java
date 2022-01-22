package L02MultidimensionalArrays.Exercise.T07Crossfire;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] matrix;
    private static int[] offset;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        matrix = new int[dimensions[0]][dimensions[1]];
        offset = new int[dimensions[0]];
        for (int i = 0; i < offset.length; i++) {
            offset[i] = 0;
        }
        int n = 1;
        for (int x = 0; x < dimensions[0]; x++) {
            for (int y = 0; y < dimensions[1]; y++) {
                matrix[x][y] = n++;
//                System.out.printf("%d ", matrix[x][y]);
            }
//            System.out.println();
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            nuke(data[0], data[1], data[2]);
            input = scanner.nextLine();
        }
        for (int x = 0; x < dimensions[0]; x++) {
            for (int y = 0; y < dimensions[1]; y++) {
                if (matrix[x][y] != 0)
                    System.out.printf("%d ", matrix[x][y]);
            }
            System.out.println();
        }
    }

    private static void nuke(int x, int y, int radius) {
        int dy = matrix.length;
        int dx = matrix[0].length;

        for (int i = x - radius; i < x + radius; i++) {
            if (i >= 0 && y >= 0 && i < dx && y < dy) {
                matrix[i][y] = 0;
            }
        }
        for (int i = y - radius; i < y + radius; i++) {
            if (x >= 0 && i >= 0 && x < dx && i < dy) {
                matrix[x][i] = 0;
            }
        }
    }
}
