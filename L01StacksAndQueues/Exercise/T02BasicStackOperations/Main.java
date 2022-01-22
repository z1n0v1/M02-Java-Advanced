/*
    https://judge.softuni.org/Contests/Compete/Index/1442#1

    02. Basic Stack Operations

You will be given an integer N representing the number of elements to push onto the stack,
an integer S representing the number of elements to pop from the stack and finally an integer X,
an element that you should check whether is present in the stack.
If it is, print true on the console. If it’s not, print the smallest element currently present in the stack.

Input
•	On the first line, you will be given N, S and X separated by a single space.
•	On the next line, you will be given a line of numbers separated by one or more white spaces.

Output
•	On a single line print either true if X is present in the stack otherwise print the smallest element in the stack.
•	If the stack is empty print 0.
 */

package L01StacksAndQueues.Exercise.T02BasicStackOperations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = data[0], s = data[1], x = data[2];
        data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        if (s >= n)
            System.out.println(0);
        else {
            for (int i = 0; i < n; i++) {
                numbers.push(data[i]);
            }
            for (int i = 0; i < s; i++) {
                numbers.pop();
            }
            int smallest = Integer.MAX_VALUE;
            boolean isFound = false;
            for (Integer number : numbers) {
                if (number == x) {
                    System.out.println("true");
                    isFound = true;
                    break;
                } else {
                    if (number < smallest)
                        smallest = number;
                }
            }
            if (!isFound)
                System.out.println(smallest);
        }


    }
}
