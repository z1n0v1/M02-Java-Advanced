/*
    https://judge.softuni.org/Contests/Practice/Index/1437#1

    02. Simple Calculator

Create a simple calculator that can evaluate simple expressions that will not hold any operator different
from addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.

 */

package L01StacksAndQueues.Lab.T02SimpleCalculator;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String[] data = "2 + 5 + 10 - 2 - 1".split("\\s+");
        String[] data = scanner.nextLine().split("\\s+");
        ArrayDeque<String> calculations = new ArrayDeque<>();
        Collections.addAll(calculations, data);

        while (calculations.size() > 1) {
            int a = Integer.parseInt(calculations.pop());
            String sign = calculations.pop();
            int b = Integer.parseInt(calculations.pop());
            if (sign.equals("+")) calculations.push("" + (a + b));
            else calculations.push("" + (a - b));
        }
        System.out.println(calculations.pop());


    }
}
