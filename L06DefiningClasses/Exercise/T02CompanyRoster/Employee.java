package L06DefiningClasses.Exercise.T02CompanyRoster;

public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, Double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, Double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

}
