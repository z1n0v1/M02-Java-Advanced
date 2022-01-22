package L04StreamsFilesAndDirectories.Exercise.T09CopyAPicture;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        String inPath = "C:\\data\\picture.jpg";
        String outPath = "C:\\data\\picture-copy.jpg";
        try {
            FileInputStream inputStream = new FileInputStream(inPath);
            FileOutputStream outputStream = new FileOutputStream(outPath);

            byte[] pic = inputStream.readAllBytes();
            outputStream.write(pic);
            inputStream.close();
            outputStream.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
