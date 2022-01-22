/*
    https://judge.softuni.org/Contests/Practice/Index/1437#5

    06. Hot Potato

Hot potato is a game in which children form a circle and start passing a hot potato.
The counting starts with the fist kid. Every nth toss the child left with the potato leaves the game.
When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato.
Print every kid that is removed from the circle. In the end, print the kid that is left last.
 */

package L01StacksAndQueues.Lab.T06HotPotato;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, data);

        int nextKid = 1;

        while (kids.size() > 1) {
            String kid = kids.poll();
            if(nextKid % n == 0)
                System.out.println("Removed " + kid);
            else kids.offer(kid);
            nextKid++;
        }
        System.out.println("Last is " + kids.poll());

    }
}
