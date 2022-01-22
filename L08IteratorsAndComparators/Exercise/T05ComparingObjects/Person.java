package L08IteratorsAndComparators.Exercise.T05ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.equals(o.name)) {
            if (this.age == o.age) {
                if (this.town.equals(o.town)) {
                    return 0;
                } else {
                    return this.town.compareTo(o.town);
                }
            } else {
                return this.age - o.age;
            }
        } else {
            return  this.name.compareTo(o.name);
        }
    }
}
