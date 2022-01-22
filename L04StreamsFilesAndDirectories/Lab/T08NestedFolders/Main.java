package L04StreamsFilesAndDirectories.Lab.T08NestedFolders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String outPath = "L09StreamsFilesAndDirectories\\T08Out.txt";
        try {
            PrintWriter out = new PrintWriter(new FileWriter(outPath));
            File root = new File(inPath);
            Deque<File> dirs = new ArrayDeque<>();
            dirs.offer(root);
            int count = 0;
            while (!dirs.isEmpty()) {
                File current = dirs.poll();
                File[] files = current.listFiles();
                for (File file : files) {
                    if(file.isDirectory()) {
                        dirs.offer(file);
                    }
                }
                count++;
                out.println(current.getName());
            }
            out.println(count + " folders");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
