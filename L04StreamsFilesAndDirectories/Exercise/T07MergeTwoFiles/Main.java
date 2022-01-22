package L04StreamsFilesAndDirectories.Exercise.T07MergeTwoFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String inOnePath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inTwoPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outPath = "T07Out.txt";
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(inOnePath));
            BufferedReader reader2 = new BufferedReader(new FileReader(inTwoPath));
            PrintWriter writer = new PrintWriter(outPath);

            String line = reader1.readLine();
            while (line != null) {
                writer.println(line);
                line = reader1.readLine();
            }
            line = reader2.readLine();
            while (line != null) {
                writer.println(line);
                line = reader2.readLine();
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
