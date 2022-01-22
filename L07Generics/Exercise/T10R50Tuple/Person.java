package L07Generics.Exercise.T10R50Tuple;

public class Person {
    private String firstName, lastname;

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String toString() {
        return firstName + " " + lastname;
    }
}
