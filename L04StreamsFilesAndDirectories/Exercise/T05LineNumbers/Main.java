package L04StreamsFilesAndDirectories.Exercise.T05LineNumbers;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outPath = "T05Out.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outPath));

            String line = reader.readLine();
            int num = 1;
            while (line != null) {
                writer.printf("%d. %s%n", num, line);
                line = reader.readLine();
                num++;
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
