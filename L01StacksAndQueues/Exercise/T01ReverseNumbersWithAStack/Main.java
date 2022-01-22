/*
    https://judge.softuni.org/Contests/Compete/Index/1442#0

    01. Reverse Numbers with a Stack

Write a program that reads N integers from the console and reverses them using a stack.
Use the ArrayDeque<Integer> class.
Just put the input numbers in the stack and pop them. Examples:
 */

package L01StacksAndQueues.Exercise.T01ReverseNumbersWithAStack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> integers = new ArrayDeque<>();

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int integer : data) {
            integers.push(integer);
        }

        while (!integers.isEmpty())
            System.out.printf("%d ",integers.pop());
    }
}
