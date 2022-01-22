package L04StreamsFilesAndDirectories.Lab.T01ReadFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(path)){
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
