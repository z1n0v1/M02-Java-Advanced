package L04StreamsFilesAndDirectories.Lab.T05WriteEveryThirdLine;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "T05Out.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(inPath))){
            PrintWriter out = new PrintWriter(new FileWriter(outPath));
            int n = 1;
            String line = in.readLine();
            while (line != null) {
                if (n % 3 == 0)
                    out.println(line);
                line = in.readLine();
                n++;
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
