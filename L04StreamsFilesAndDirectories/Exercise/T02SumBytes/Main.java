package L04StreamsFilesAndDirectories.Exercise.T02SumBytes;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))){
            long sum = 0;
            String s = reader.readLine();
            while (s != null) {
                sum += asciiSum(s);
                s = reader.readLine();
            }
            System.out.println(sum);
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
