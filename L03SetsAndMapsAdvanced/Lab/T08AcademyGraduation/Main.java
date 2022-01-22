package L03SetsAndMapsAdvanced.Lab.T08AcademyGraduation;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Double> graduationList = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while ( n-- > 0) {
            String name = scanner.nextLine();
//            double avgGrade = Arrays.stream(scanner.nextLine()
//                    .split("\\s+")).mapToDouble(Double::parseDouble).average().getAsDouble();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            double avgGrade = 0;
            for (double grade : grades) avgGrade += grade;
            avgGrade /= grades.length;

            graduationList.put(name, avgGrade);
        }
        graduationList.forEach((name, grade) -> {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            decimalFormat.setMaximumFractionDigits(340);
            System.out.printf("%s is graduated with %s%n", name, decimalFormat.format(grade));
        });
    }
}
