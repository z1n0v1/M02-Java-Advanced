package L08IteratorsAndComparators.Lab.T04BookComparator;

public class BookComparator implements java.util.Comparator<Book> {
    public int compare(Book book1, Book book2) {
        return book1.compareTo(book2);
    }
}
