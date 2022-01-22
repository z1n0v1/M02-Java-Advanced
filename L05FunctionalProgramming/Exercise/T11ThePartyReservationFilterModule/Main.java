package L05FunctionalProgramming.Exercise.T11ThePartyReservationFilterModule;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        HashMap<String, Predicate<String>> filterTypes = new HashMap<>();
        List<Predicate<String>> filters = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] data = input.split(";");
            switch (data[0]) {
                case "Add filter":
                    if (!filterTypes.containsKey(data[1] + ';' + data[2]))
                        filterTypes.put(data[1] + ';' + data[2], newFilter(data[1], data[2]));
                    filters.add(filterTypes.get(data[1] + ';' + data[2]));
                    break;
                case "Remove filter":
                    filters.removeIf( filter -> filter.equals(filterTypes.get(data[1] + ';' + data[2])));
                    break;
            }
            input = scanner.nextLine();
        }
        list.stream().filter(name -> {
            boolean isPrintable = true;
            for (Predicate<String> filter : filters) {
                if (filter.test(name)) {
                    isPrintable = false;
                    break;
                }
            }
            return isPrintable;
        }).forEach(name -> {
            System.out.printf("%s ", name);
        });
    }

    private static Predicate<String> newFilter(String type, String param) {
        Predicate<String> predicate = null;
        switch (type) {
            case "Starts with":
                predicate = name -> name.startsWith(param);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(param);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(param);
                break;
            case "Contains":
                predicate = name -> name.contains(param);
                break;
        }
        return predicate;
    }
}
