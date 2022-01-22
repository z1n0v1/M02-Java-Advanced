package L04StreamsFilesAndDirectories.Lab.T09SerializeCustomObject;

import java.io.*;

public class Main {
    static class Cube implements Serializable {
        String color;
        double width, height, depth;
    }

    public static void main(String[] args) {
        String outPath = "T09Out.txt";
        Cube cube = new Cube();
        cube.color="green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath))){
            oos.writeObject(cube);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outPath));
            Cube cube1 = (Cube) ois.readObject();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
