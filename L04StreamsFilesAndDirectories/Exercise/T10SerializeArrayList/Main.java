package L04StreamsFilesAndDirectories.Exercise.T10SerializeArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String outPath = "list.ser";
        try {
            List<Double> list = new ArrayList<>() {{
                add(1.0);
                add(1.1);
                add(1.4);
                add(-1.0);
                add(-1.1);
            }};
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outPath));
            outputStream.writeObject(list);
            outputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(outPath));
            List<Double> list1 = (List<Double>) inputStream.readObject();
            System.out.println();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
