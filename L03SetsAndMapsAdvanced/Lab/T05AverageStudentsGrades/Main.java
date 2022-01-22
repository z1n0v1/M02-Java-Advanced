package L03SetsAndMapsAdvanced.Lab.T05AverageStudentsGrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, ArrayList<Double>> studentRecords = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if(!studentRecords.containsKey(data[0]))
                studentRecords.put(data[0], new ArrayList<>());
            studentRecords.get(data[0]).add(Double.parseDouble(data[1]));
        }
        studentRecords.forEach((student, grades) -> {
            System.out.printf("%s -> ", student);
            grades.forEach(grade -> System.out.printf("%.2f ", grade));
//            double avgGrade = grades.stream().mapToDouble(e -> e).average().getAsDouble();
            double avgGrade = 0;
            for (double grade : grades) avgGrade += grade;
            avgGrade /= grades.size();
            System.out.printf("(avg: %.2f)%n", avgGrade);
        });
    }
}
