package L07Generics.Exercise.T08CustomListSorter;

public class Sorter<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort(CustomList list) {
        for (int index = 0; index < list.getElements().size(); index++) {
            int size = list.getElements().size();
            for (int i = 0; i < size; i++) {
                T element = (T) list.getElements().get(i);
                for (int j = i + 1; j < size; j++) {
                    T nextElement = (T) list.getElements().get(j);
                    if (element.compareTo(nextElement) > 0) {
                        list.swap(i, j);
                    }
                }
            }
        }
    }
}
