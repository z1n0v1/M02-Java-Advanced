/*
    https://judge.softuni.org/Contests/Practice/Index/1437#6

    07. Math Potato

Rework the previous problem so that a child is removed only on a composite (not prime) cycle
(cycles start from 1)
If a cycle is prime, just print the child's name.
As before, print the name of the child that is left last.
 */

package L01StacksAndQueues.Lab.T07MathPotato;

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

//        int nextKid = 1;
        int cycles = 1;



        while (kids.size() > 1) {
//            String potatoKid = kids.poll();;
            for (int i = 1; i < n; i++) {
                String potatoKid = kids.poll();
                kids.offer(potatoKid);
            }
            String potatoKid = kids.peek();
            if(isComposite(cycles)) {
                System.out.println("Removed " + potatoKid);
                kids.poll();
            } else {
                System.out.println("Prime " + potatoKid);
//                kids.offer(potatoKid);
            }

            cycles++;
        }

        /*
        while (kids.size() > 1) {
            String kid = kids.poll();
            if (nextKid % n == 0) {
                if (isComposite(nextKid)) {
                    System.out.println("Removed " + kid);
                } else {
                    System.out.println("Prime " + kid);
                    kids.offer(kid);
                }
            } else kids.offer(kid);
            nextKid++;
        }
*/
            System.out.println("Last is " + kids.poll());
    }

    private static boolean isComposite(int numCycles) {
        if (numCycles == 1)
            return true;
        for (int i = 2; i < numCycles; i++) {
            if (numCycles % i == 0)
                return true;
        }
        return false;
    }
}
