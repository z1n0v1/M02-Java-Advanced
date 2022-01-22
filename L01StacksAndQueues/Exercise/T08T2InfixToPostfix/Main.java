/*
    https://judge.softuni.org/Contests/Compete/Index/1442#7

    08. Infix to Postfix // This one works

Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )".
However, this kind of notation is not efficient for computer processing,
as you first need to evaluate the expression inside the brackets, so there is a lot of back and forth movement.
A more suitable approach is to convert it in the so-called postfix notations (also called Reverse Polish Notation),
in which the expression is evaluated from left to right, for example "3 2 + 5 /".
Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation.
Use the famous Shunting-yard algorithm.

Input
•	You will receive an expression on a single line, consisting of tokens
•	Tokens could be numbers 0-9, variables a-z, operators +, -, *, / and brackets ( or )
•	Each token is separated by exactly one space

Output
•	The output should be on a single line, consisting of tokens, separated by exactly one space.
 */

package L01StacksAndQueues.Exercise.T08T2InfixToPostfix;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] infixFormula = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String symbol : infixFormula) {

            if (Character.isLetterOrDigit(symbol.charAt(0)))
                queue.offer(symbol);

            else if (symbol.equals("("))
                stack.push(symbol);
            else if (symbol.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                    queue.offer(stack.pop());
                stack.pop();
            } else {

                while (!stack.isEmpty()
                        && getPrecedence(symbol.charAt(0))
                        <= getPrecedence(stack.peek().charAt(0)))
                    queue.offer(stack.pop());
                stack.push(symbol);
            }
        }
        while (!stack.isEmpty())
            queue.offer(stack.pop());
        while (!queue.isEmpty())
            System.out.printf("%s ", queue.poll());
    }

    static int getPrecedence(char ch) {

        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
}
