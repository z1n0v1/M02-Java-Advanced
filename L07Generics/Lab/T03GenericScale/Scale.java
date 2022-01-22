package L07Generics.Lab.T03GenericScale;

public class Scale<T extends Comparable<T>> {

    T left, right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.equals(right))
            return null;
        return left.compareTo(right) > 0 ? left : right;
    }
}
