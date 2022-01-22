package L07Generics.Exercise.T07CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int leftIndex, int rightIndex) {
        T temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T currentElement : list)
            if (currentElement.compareTo(element) > 0)
                count++;
        return count;
    }

    public T getMax() {
        if(list.isEmpty())
            throw new IndexOutOfBoundsException("Max element of empty list");
        T max = list.get(0);
        for (T element : list)
            if (element.compareTo(max) > 0)
                max = element;
        return max;
    }

    public T getMin() {
        if(list.isEmpty())
            throw new IndexOutOfBoundsException("Min element of empty list");
        T min = list.get(0);
        for (T element : list)
            if (element.compareTo(min) < 0)
                min = element;
        return min;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
