package L07Generics.Exercise.T08CustomListSorter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {
    public List<T> getElements() {
        return elements;
    }

    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }


    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int leftIndex, int rightIndex) {
        T temp = elements.get(leftIndex);
        elements.set(leftIndex, elements.get(rightIndex));
        elements.set(rightIndex, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T currentElement : elements)
            if (currentElement.compareTo(element) > 0)
                count++;
        return count;
    }

    public T getMax() {
        if(elements.isEmpty())
            throw new IndexOutOfBoundsException("Max element of empty list");
        T max = elements.get(0);
        for (T element : elements)
            if (element.compareTo(max) > 0)
                max = element;
        return max;
    }

    public T getMin() {
        if(elements.isEmpty())
            throw new IndexOutOfBoundsException("Min element of empty list");
        T min = elements.get(0);
        for (T element : elements)
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
            return index < elements.size();
        }

        @Override
        public T next() {
            return elements.get(index++);
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
