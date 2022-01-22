package L02MultidimensionalArrays.Exercise.T07T2Crossfire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<List<Integer>> matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        matrix = new ArrayList<>(); //int[dimensions[0]][dimensions[1]];
//        matrix = new int[dimensions[0]][dimensions[1]];
        int n = 1;

        for (int row = 0; row < dimensions[0]; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < dimensions[1]; col++) {
                currentRow.add(n++);
//                matrix[x][y] = n++;
//                if (matrix.)
//                System.out.printf("%d ", matrix[x][y]);
            }
            matrix.add(currentRow);
//            System.out.println();
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            nuke(data[0], data[1], data[2]);
            input = scanner.nextLine();
        }
        print();
    }

    private static void print() {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.printf("%d ", matrix.get(row).get(col));
//                if (matrix[x][y] != 0)
//                    System.out.printf("%d ", matrix[x][y]);
//                System.out.println();
            }
            System.out.println();
        }
    }

    private static void nuke(int row, int col, int radius) {
//        if (row < 0 || row >= matrix.size() || col < 0 || col >= matrix.get(row).size()) return;

        for (int currentCol = col + radius; currentCol >= col - radius ; currentCol--) {
            if(currentCol >= 0 && row >= 0 && row < matrix.size() && currentCol < matrix.get(row).size()) {
                matrix.get(row).remove(currentCol);
//                if (matrix.get(row).isEmpty())
//                    matrix.remove(row);
            }
        }
        for (int currentRow = row + radius; currentRow >= row - radius ; currentRow--) {
            if (currentRow == row) continue;
            if (currentRow >= 0 && currentRow < matrix.size() && col >= 0 && col < matrix.get(currentRow).size())
                matrix.get(currentRow).remove(col);
        }

        matrix.removeIf(List::isEmpty);
 /*       for (int i = col + radius; i >= col - radius ; i--) {
            if(i >= 0 && row < matrix.size()  && i < matrix.get(row).size())
                matrix.get(row).remove(i);
        }
        for (int i = row + radius; i >=  row - radius; i--) {
            if (i == col) continue;
            if (i >= 0 && i < matrix.size() && col < matrix.get(i).size())
                matrix.get(i).remove(col);
        }
*/
        /*
        //        List<Integer> row = matrix.get(x);

        for (int i = x + radius; i >= x - radius ; i--) {
            if(i>= 0 && i< matrix.get(x).size())
                matrix.get(x).remove(i);
//                row.remove(i);
        }
//        matrix.set(x, row);
        for (int i = y + radius; i >= y - radius ; i--) {
            if(x == i) continue;
            if (i >= 0 && i < matrix.size() && matrix.get(i).size() > x)
                matrix.get(i).remove(x);
//            if(i >= 0 && i < matrix.size() && matrix.get())
//            matrix.get(i)
        }
//        for (int i = x + radius; i < x - radius; i--) {
//
//            //            matrix[i][y] = 0;
//        }
//        for (int i = y - radius + 1; i < y + radius - 1; i++) {
//            matrix[x][i] = 0;
//        }
    */
    }
}
