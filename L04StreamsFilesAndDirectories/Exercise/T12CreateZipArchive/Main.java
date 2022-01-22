package L04StreamsFilesAndDirectories.Exercise.T12CreateZipArchive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];

        File[] srcFiles = {
                new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"),
                new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"),
                new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"),
        };
        File base = new File("C:\\data");
//        File base = new File("C:\\data\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");
        String zipFilePath = "C:\\data\\T12.zip";

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
            for (File srcFile : srcFiles) {
                FileInputStream inputStream = new FileInputStream(srcFile);
//                String name = base.toURI().relativize(srcFile.toURI()).getPath();
                String name = srcFile.getName();
                zipOutputStream.putNextEntry(new ZipEntry(name));

                int length;
                int offset = 0;
                while ((length = inputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, offset, length);
                    offset += length;
                }
                zipOutputStream.closeEntry();
                inputStream.close();
            }
            zipOutputStream.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
