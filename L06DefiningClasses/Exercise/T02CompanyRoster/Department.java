package L06DefiningClasses.Exercise.T02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public Double getAverageSalary() {
        double averageSalary = 0;
        for (Employee employee : employees) {
            averageSalary += employee.getSalary();
        }
        return averageSalary / employees.size();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployees() {
        employees.stream().sorted((a, b) -> b.getSalary().compareTo(a.getSalary()))
                .forEach(System.out::println);
    }
}
