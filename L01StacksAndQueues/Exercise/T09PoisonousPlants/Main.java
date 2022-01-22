/*
    https://judge.softuni.org/Contests/Compete/Index/1442#8

    09. Poisonous Plants

You are given N plants in a garden. Each of these plants has been added with some amount of pesticide.
After each day, if any plant has more pesticide than the plant at its left, being weaker (more GMO) than the left one,
it dies. You are given the initial values of the pesticide and position of each plant.
Print the number of days after which no plant dies, i.e. the time after which there are no plants
with more pesticide content than the plant to their left.

Input
•	The input consists of an integer N representing the number of plants.
•	The next single line consists of N integers, where every integer represents the position
and amount of pesticides of each plant. 1 ≤ N ≤ 100000
•	Pesticides amount on a plant is between 0 and 1000000000

Output
•	Output a single value equal to the number of days after which no plants die
 */

package L01StacksAndQueues.Exercise.T09PoisonousPlants;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    private static ArrayDeque<Integer> plants;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlants = Integer.parseInt(scanner.nextLine());

        plants = new ArrayDeque<>();

        for (int i = 0; i < numPlants; i++) {
            plants.push(scanner.nextInt());
        }
        scanner.nextLine();

        int days = 0;
        while (plants.size() > killWeakerPlants())
            days++;
        System.out.println(days);


    }
    private static int killWeakerPlants() {
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        while (!plants.isEmpty()) {
            int plantPesticide = plants.pop();
            if(!plants.isEmpty() && plantPesticide<=plants.peek()) {
                temp.push(plantPesticide);
            }
//                temp.push(plants.pop());
            else if (plants.isEmpty())
                temp.push(plantPesticide);
        }
        plants.clear();
        while (!temp.isEmpty())
            plants.push(temp.pop());
        return plants.size();
    }
}
