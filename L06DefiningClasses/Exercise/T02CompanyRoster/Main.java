package L06DefiningClasses.Exercise.T02CompanyRoster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Department> departments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            Employee employee = null;
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length == 6) {
                employee = new Employee(data[0], Double.parseDouble(data[1]),
                        data[2], data[3], data[4], Integer.parseInt(data[5]));
            } else if (data.length == 4) {
                employee = new Employee(data[0], Double.parseDouble(data[1]),
                        data[2], data[3]);
            } else if (data.length == 5) {
                if(data[4].contains("@")) {
                    employee = new Employee(data[0], Double.parseDouble(data[1]),
                            data[2], data[3], data[4]);
                } else {
                    employee = new Employee(data[0], Double.parseDouble(data[1]),
                            data[2], data[3], Integer.parseInt(data[4]));
                }
            }
            if (!departments.containsKey(employee.getDepartment()))
                departments.put(employee.getDepartment(), new Department(employee.getDepartment()));
            departments.get(employee.getDepartment()).addEmployee(employee);
        }
        List<Map.Entry<String, Department>> department = departments.entrySet().stream().
                sorted((a,b) -> b.getValue().getAverageSalary().compareTo(a.getValue().getAverageSalary()))
                .limit(1).collect(Collectors.toList());
        System.out.printf("Highest Average Salary: %s%n", department.get(0).getKey());
        department.get(0).getValue().printEmployees();
    }
}
