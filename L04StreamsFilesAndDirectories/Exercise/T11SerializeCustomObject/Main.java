package L04StreamsFilesAndDirectories.Exercise.T11SerializeCustomObject;

import java.io.*;

public class Main {
    static class Course implements Serializable {
        String name;
        int num;

        public Course(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        String outPath = "course.ser";
        try {
            Course course = new Course("course", 42);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outPath));
            outputStream.writeObject(course);
            outputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(outPath));
            Course course1 = (Course) inputStream.readObject();
            System.out.println();
            inputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
