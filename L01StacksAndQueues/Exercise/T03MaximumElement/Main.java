/*
    https://judge.softuni.org/Contests/Compete/Index/1442#2

    03. Maximum Element

You have an empty sequence, and you will be given N commands. Each command is one of the following types:
•	"1 X" - Push the element X into the stack.
•	"2" - Delete the element present at the top of the stack.
•	"3" - Print the maximum element in the stack.

Input
•	The first line of input contains an integer N, where 1 ≤ N ≤ 105
•	The next N lines contain commands. All commands will be valid and in the format described
•	The element X will be in range 1 ≤ X ≤ 109
•	The type of the command will be in range 1 ≤ Type ≤ 3

Output
•	For each command of type "3", print the maximum element in the stack on a new line.
 */

package L01StacksAndQueues.Exercise.T03MaximumElement;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static ArrayDeque<Integer> sequence;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sequence = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            switch (data[0]) {
                case "1":
                    sequence.push(Integer.parseInt(data[1]));
                    break;
                case "2":
                    sequence.pop();
                    break;
                case "3": {
                    int maxNumber = Integer.MIN_VALUE;
                    for (Integer integer : sequence) {
                        if(integer > maxNumber)
                             maxNumber = integer;
                    }
                    System.out.println(maxNumber);
                }
            }
        }

    }
}
