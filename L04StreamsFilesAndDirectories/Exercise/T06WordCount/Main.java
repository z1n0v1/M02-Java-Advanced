package L04StreamsFilesAndDirectories.Exercise.T06WordCount;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String wordsPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String textPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outPath = "T06Out.txt";
        try {
            BufferedReader wordsReader = Files.newBufferedReader(Paths.get(wordsPath));
            BufferedReader textReader = Files.newBufferedReader(Paths.get(textPath));
            PrintWriter writer = new PrintWriter(outPath);

            LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();
            for (String word : wordsReader.readLine().split("\\s+"))
                wordsMap.put(word, 0);

            String line = textReader.readLine();
            while (line != null) {
                for (String word : line.split("\\s++")) {
                    if(wordsMap.containsKey(word))
                        wordsMap.put(word, wordsMap.get(word) + 1);
                }
                line = textReader.readLine();
            }
            wordsMap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(word -> {
                writer.printf("%s - %d%n", word.getKey(), word.getValue());
            });
            writer.close();
            wordsReader.close();
            textReader.close();

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
