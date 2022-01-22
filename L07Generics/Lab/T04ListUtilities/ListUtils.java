package L07Generics.Lab.T04ListUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0)
            throw new  IllegalArgumentException("Empty list");
        T min = list.get(0);
        for (T element : list)
            if (element.compareTo(min) < 0)
                min = element;
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0)
            throw new IllegalArgumentException("Empty list");
        T max = list.get(0);
        for (T element : list)
            if (element.compareTo(max) > 0)
                max = element;
        return max;
    }

}
