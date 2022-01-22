package L04StreamsFilesAndDirectories.Lab.T02WriteToFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inPath = "input.txt";
        String outPath = "T02Out.txt";
//        List<Character> punctoation = new ArrayList<Character>();
        List punctuation = Arrays.asList(',', '.', '!', '?');
        try (FileInputStream in = new FileInputStream(inPath)){
            try (FileOutputStream out = new FileOutputStream(outPath)){
                int symbol = in.read();
                while (symbol >= 0) {
                    if (!punctuation.contains((char) symbol))
                        out.write(symbol);
                    symbol = in.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
