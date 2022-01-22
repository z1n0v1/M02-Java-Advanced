package L08IteratorsAndComparators.Exercise.T01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private int index;
    private List<String> list;

    public ListyIterator(String[] strings) {
        index = 0;
        if(strings.length == 0)
            list = new ArrayList<>();
        else list = Arrays.asList(strings);
    }

    public boolean move() {
        if(hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if(index == list.size() - 1)
            return false;
        return true;
    }

    public void print() {
        if(list.isEmpty()) {
//            throw new IndexOutOfBoundsException("Invalid Operation!");
            System.out.println("Invalid Operation!");
        }
        else System.out.println(list.get(index));
    }
}
