package L04StreamsFilesAndDirectories.Lab.T06SortLines;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path inPath = Paths.get("04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outPath = Paths.get("T06Out.txt");
        try {
            List<String> lines = Files.readAllLines(inPath);
            lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outPath,lines);
//            for (String line : lines)
//                out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
