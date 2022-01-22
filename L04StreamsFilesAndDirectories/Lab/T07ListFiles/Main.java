package L04StreamsFilesAndDirectories.Lab.T07ListFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        Path inPath = Paths.get("C:\\data\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        String inPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String outPath = "T07Out.txt";

        try {
            File file = new File(inPath);
            if (file.exists() && file.isDirectory()) {
                File[] files = file.listFiles();
                PrintWriter out = new PrintWriter(new FileWriter(outPath));
                for (File file1 : files) {
                    if (!file1.isDirectory())
                        out.printf("%s: [%d]%n", file1.getName(), file1.length());
                }
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
