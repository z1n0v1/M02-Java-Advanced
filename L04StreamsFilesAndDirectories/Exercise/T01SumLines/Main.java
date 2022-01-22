package L04StreamsFilesAndDirectories.Exercise.T01SumLines;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inPath));
            String s = reader.readLine();
            while (s != null) {
                System.out.println(asciiSum(s));
                s = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int asciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
