package L08IteratorsAndComparators.Exercise.T03StackIterator;

import java.util.Iterator;

public class IntStack implements Iterable<Integer> {
    private int[] stack;
    private int top;

    public IntStack() {
        this.stack = new int[32];
        top = -1;
    }

    public void pop() {
        if (top < 0)
            System.out.println("No elements");
        else {
            top--;
        }
    }

    public void push(int element) {
        if (top == 31) {
            System.out.println("Stack overflow");
        } else {
            stack[++top] = element;
        }
    }

    public Iterator<Integer> iterator() {
        return new IteratorInt();
    }

    private final class IteratorInt implements Iterator<Integer> {
        private int count = top;

        @Override
        public boolean hasNext() {
            if (count < 0)
                return false;
            return true;
        }

        @Override
        public Integer next() {
            return stack[count--];
        }
    }
}
