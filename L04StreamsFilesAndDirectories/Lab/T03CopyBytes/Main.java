package L04StreamsFilesAndDirectories.Lab.T03CopyBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inPath = "input.txt";
        String outPath = "T03Out.txt";

        try (FileInputStream in = new FileInputStream(inPath)){
            FileOutputStream out = new FileOutputStream(outPath);

            int currentByte = in.read();
            while (currentByte >=0) {

                if(' ' == (char) currentByte || '\n' == (char) currentByte) {
                    out.write(currentByte);
                } else {
                    for (char c : String.valueOf(currentByte).toCharArray())
                        out.write(c);
                }
                currentByte = in.read();
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
