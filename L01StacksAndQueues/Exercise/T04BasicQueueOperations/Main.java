/*
    https://judge.softuni.org/Contests/Compete/Index/1442#3

    04. Basic Queue Operations

You will be given an integer N representing the number of elements to enqueue (add),
an integer S representing the number of elements to dequeue (remove/poll) from the queue and finally an integer X,
an element that you should check whether is present in the queue.
If it is print true on the console, if it’s not print the smallest element currently present in the queue.
 */

package L01StacksAndQueues.Exercise.T04BasicQueueOperations;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            numbers.offer(scanner.nextInt());
        }
        scanner.nextLine();
        for (int i = 0; i < s; i++) {
            numbers.poll();
        }
        if (numbers.isEmpty()) {
            System.out.println(0);
        } else {
            boolean isFound = false;
            int smallestNum = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number == x) {
                    isFound = true;
                    System.out.println(true);
                    break;
                }
                if (number < smallestNum)
                    smallestNum = number;
            }
            if (!isFound)
                System.out.println(smallestNum);
        }

    }
}
