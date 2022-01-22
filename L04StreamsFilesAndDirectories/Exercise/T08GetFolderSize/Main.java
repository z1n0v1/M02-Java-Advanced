package L04StreamsFilesAndDirectories.Exercise.T08GetFolderSize;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String rootPath = "C:\\data\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        Deque<File> dirs = new ArrayDeque<>();
        File root = new File(rootPath);
        dirs.offer(root);
        int size = 0;
        try {
            while (!dirs.isEmpty()) {
                File current = dirs.poll();
                File[] files = current.listFiles();
                for (File file : files) {
                    if(file.isDirectory()) {
                        dirs.offer(file);
                    } else {
                        size += file.length();
                    }
                }
            }
            System.out.println("Folder size: " + size);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
