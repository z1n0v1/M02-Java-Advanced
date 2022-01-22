package L07Generics.Lab.T01JarOfT;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

        jar.add(11);
        jar.add(12);
        jar.add(14);
        jar.remove();
    }
}
