/*
    https://judge.softuni.org/Contests/Compete/Index/1442#4

    05. Balanced Parentheses

Given a sequence consisting of parentheses, determine whether the expression is balanced.
A sequence of parentheses is balanced if every open parenthesis can be paired uniquely
with a closed parenthesis that occurs after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
{[()]} - This is a balanced parenthesis.
{[(])} - This is not a balanced parenthesis.

Input
•	Each input consists of a single line, the sequence of parentheses.
•	1 ≤ Length of sequence ≤ 1000
•	Each character of the sequence will be one of the following: {, }, (, ), [, ].

Output
•	For each test case, print on a new line "YES" if the parentheses are balanced. Otherwise, print "NO".
 */

package L01StacksAndQueues.Exercise.T05BalancedParentheses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    parentheses.push(input.charAt(i));
                    break;
                case ')': {
                    if(parentheses.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    if (parentheses.peek() == '(') {
                        parentheses.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                    break;
                }
                case '}': {
                    if(parentheses.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    if (parentheses.peek() == '{') {
                        parentheses.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                    break;
                }
                case ']': {
                    if(parentheses.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    if (parentheses.peek() == '[') {
                        parentheses.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                    break;
                }
            }
            if(!isBalanced) break;
        }
        if(isBalanced) System.out.println("YES");
        else System.out.println("NO");
    }
}
