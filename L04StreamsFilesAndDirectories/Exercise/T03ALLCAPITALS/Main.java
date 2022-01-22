package L04StreamsFilesAndDirectories.Exercise.T03ALLCAPITALS;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "T03Out.txt";
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inPath));
            PrintWriter writer = new PrintWriter(outPath);
            String s = reader.readLine();
            while (s != null) {
                writer.println(s.toUpperCase());
                s = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
