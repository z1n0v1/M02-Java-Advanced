package L07Generics.Exercise.T05GenericCountMethodString;

public class Box <T extends Comparable<T>> implements Comparable<Box<T>> {
    T data;
    public Box(T value) {
        data = value;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return String.format("%s: %s", data.getClass().getName(), data);
    }

    public int compareTo(Box<T> o) {
        return this.getData().compareTo(o.getData());
    }
}
