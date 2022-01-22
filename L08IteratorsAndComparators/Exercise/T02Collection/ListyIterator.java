package L08IteratorsAndComparators.Exercise.T02Collection;

import java.util.*;

public class ListyIterator implements Iterable<String> {
    private int index;
    private List<String> list;

    public ListyIterator(String[] strings) {
        index = 0;
        if (strings.length == 0)
            list = new ArrayList<>();
        else list = Arrays.asList(strings);
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (index == list.size() - 1)
            return false;
        return true;
    }

    public void print() {
        if (list.isEmpty()) {
//            throw new IndexOutOfBoundsException("Invalid Operation!");
            System.out.println("Invalid Operation!");
        } else System.out.println(list.get(index));
    }

    public Iterator<String> iterator() {
        return new IteratorListy();


    }

    private final class IteratorListy implements Iterator<String> {

        private int count = 0;

        @Override
        public boolean hasNext() {
            if (count == list.size())
                return false;
            return true;

        }

        @Override
        public String next() {
            return list.get(count++);
        }
    }
}
