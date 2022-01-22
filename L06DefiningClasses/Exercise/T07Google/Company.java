package L06DefiningClasses.Exercise.T07Google;

public class Company {
    private String name;
    private String department;
    private Double salary;

    public Company(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return String.format("%s %s %.2f", name, department, salary);
    }
}
