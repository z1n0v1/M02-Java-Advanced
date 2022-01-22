package L04StreamsFilesAndDirectories.Lab.T04ExtractIntegers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "T04Out.txt";
        try {
            Scanner scanner = new Scanner(new FileInputStream(inPath));
            PrintWriter out = new PrintWriter(outPath);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    out.println(scanner.nextInt());
                System.out.println(scanner.next());
            }
            out.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
