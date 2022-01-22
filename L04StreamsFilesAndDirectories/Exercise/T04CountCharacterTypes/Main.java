package L04StreamsFilesAndDirectories.Exercise.T04CountCharacterTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inPath = "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "T04Out.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inPath));
            PrintWriter writer = new PrintWriter(outPath);
            int vowels = 0, consonants = 0, punctuation = 0;
            String s = reader.readLine();
            while (s != null) {
                for (char c :  s.toCharArray()) {
                    if(c == '!' || c == '.' || c == ',' || c == '?') {
                        punctuation++;
                    } else if (
                            c == 'a' ||
                            c == 'e' ||
                            c == 'i' ||
                            c == 'o' ||
                            c == 'u'
                    ) {
                        vowels++;
                    } else if (c != ' '){
                        consonants++;
                    }
                }
                s = reader.readLine();
            }
            writer.printf("Vowels: %d%n", vowels);
            writer.printf("Consonants: %d%n", consonants);
            writer.printf("Punctuation: %d%n", punctuation);
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
