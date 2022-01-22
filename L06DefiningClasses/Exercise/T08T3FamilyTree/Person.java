package L06DefiningClasses.Exercise.T08T3FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String date;
    private List<Person> parents;
    private List<Person> children;

    public String toString() {
        return String.format("%s %s", name, date);
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person(String name, String date) {
        this.name = name;
        this.date = date;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
