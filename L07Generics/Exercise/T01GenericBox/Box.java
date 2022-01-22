package L07Generics.Exercise.T01GenericBox;

public class Box <T> {
    T data;
    public Box(T value) {
        data = value;
    }

    public String toString() {
        return String.format("%s: %s", data.getClass().getName(), data);
    }
}
