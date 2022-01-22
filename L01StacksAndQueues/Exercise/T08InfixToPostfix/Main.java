/*
    https://judge.softuni.org/Contests/Compete/Index/1442#7

    08. Infix to Postfix

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

package L01StacksAndQueues.Exercise.T08InfixToPostfix;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inflixFormula = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String token : inflixFormula) {
            if (Character.isLetterOrDigit(token.charAt(0))) {
                queue.offer(token);
            }

            switch (token) {
                case "(":
                    stack.push(token);
                    break;
                case ")":
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        queue.offer(stack.pop());
                    stack.pop();
                    break;
                case "+":
                case "-":
                    while (!stack.isEmpty() && !stack.peek().equals("("))
//                            && ((stack.peek().equals("*") || stack.peek().equals("/"))))
//                            || (stack.peek().equals("+") || stack.peek().equals("-"))))
                        queue.offer(stack.pop());
                case "*":
                case "/":
                    stack.push(token);
                    break;


//                    break;
//                    stack.push(token);
//                    break;
            }
        }
        while (!queue.isEmpty())
            System.out.printf("%s ", queue.pollFirst());
        while (!stack.isEmpty())
            System.out.printf("%s ", stack.pop());
    }

    static int getPrecedence(char ch)
    {

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
