/*
    https://judge.softuni.org/Contests/Practice/Index/1437#2

    03. Decimal To Binary

Create a simple program that can convert a decimal number to its binary representation.
Implement an elegant solution using a Stack.
Print the binary representation back at the terminal.

Hints
•	If the given number is 0, just print 0
•	Else, while the number is greater than zero, divide it by 2 and push the reminder into the stack
•	When you are done dividing, pop all reminders from the stack, that is the binary representation
 */

package L01StacksAndQueues.Lab.T03DecimalToBinary;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();

        do {
            binaryNum.push( num % 2);
            num /= 2;
        } while (num != 0);
        while (!binaryNum.isEmpty())
            System.out.print(binaryNum.pop());
    }
}
