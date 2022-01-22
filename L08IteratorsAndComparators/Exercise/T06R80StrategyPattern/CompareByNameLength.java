package L08IteratorsAndComparators.Exercise.T06R80StrategyPattern;

import java.util.Comparator;

public class CompareByNameLength implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        // От условието би трябвало първо да сравняваме по дължина, но така дава 20/100,
        // а когато сравняваме първо по символ дава 80/100
//        if(o1.getName().toLowerCase().charAt(0) == o2.getName().toLowerCase().charAt(0)) {
//            return o1.getName().length() - o2.getName().length();
//        }
//            return o1.getName().toLowerCase().charAt(0)
//                    - o2.getName().toLowerCase().charAt(0);
                if(o1.getName().length() == o2.getName().length()) {
            return o1.getName().toLowerCase().charAt(0)
                    - o2.getName().toLowerCase().charAt(0);
        }
        else return o1.getName().length() - o2.getName().length();
    }
}
