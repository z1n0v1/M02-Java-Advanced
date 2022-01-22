package L07Generics.Lab.T01JarOfT;

import java.util.ArrayDeque;

public class Jar<Type> {
    private ArrayDeque<Type> deque;

    public Jar() {
        this.deque = new ArrayDeque<>();
    }

    public void add(Type element) {
        this.deque.push(element);
    }

    public Type remove() {
        return this.deque.pop();
    }

    public int size() {
        return this.deque.size();
    }
}
