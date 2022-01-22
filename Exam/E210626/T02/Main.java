package Exam.E210626.T02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[][] matrix;
    private static int pythonRow, pythonCol, dimensions, foodToEat, pythonLength;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        pythonLength = 1;
        dimensions = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",\\s*");
        matrix = new char[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            String[] rowString = reader.readLine().split("\\s+");
            for (int col = 0; col < rowString.length; col++) {
                matrix[row][col] = rowString[col].charAt(0);
            }
        }
        ingestMatrix();

        boolean isDead = false;
        for (String command : commands) {

            if(foodToEat == 0) break;

            move(command);

            if(matrix[pythonRow][pythonCol] == 'f') {
                matrix[pythonRow][pythonCol] = '*';
                foodToEat--;
                pythonLength++;
            } else if (matrix[pythonRow][pythonCol] == 'e') {
                isDead = true;
                break;
            }
        }

        if(isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if (foodToEat > 0) {
                System.out.printf("You lose! There is still %d food to be eaten.", foodToEat);
            } else {
                System.out.printf("You win! Final python length is %d", pythonLength);
            }
        }
    }

    private static void move(String command) {
        switch (command) {
            case "up":
                pythonRow--;
                break;
            case "down":
                pythonRow++;
                break;
            case "left":
                pythonCol--;
                break;
            case "right":
                pythonCol++;
                break;
        }
        if (pythonRow < 0) pythonRow = dimensions - 1;
        if (pythonCol < 0) pythonCol = dimensions - 1;
        if (pythonRow >= dimensions) pythonRow = 0;
        if (pythonCol >= dimensions) pythonCol = 0;
    }

    private static void ingestMatrix() {
        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                if (matrix[row][col] == 'f') {
                    foodToEat++;
                } else if (matrix[row][col] == 's') {
                    pythonRow = row;
                    pythonCol = col;
                }
            }
        }
    }


}
