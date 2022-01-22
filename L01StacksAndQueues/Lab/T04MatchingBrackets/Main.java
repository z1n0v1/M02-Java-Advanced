/*
    https://judge.softuni.org/Contests/Practice/Index/1437#3

    04. Matching Brackets

We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.

Hints
•	Use a stack, namely an ArrayDeque()
•	Scan through the expression searching for brackets
o	If you find an opening bracket, push the index into the stack
o	If you find a closing bracket pop the topmost element from the stack. This is the index of the opening bracket.
o	Use the current and the popped index to extract the sub-expression
 */

package L01StacksAndQueues.Lab.T04MatchingBrackets;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int index = 0; index < expression.length(); index++) {
            if(expression.charAt(index) == '(') {
                indexes.push(index);
            } else if(expression.charAt(index) == ')') {
                int startIndex = indexes.pop();
                String contents = expression.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }
}
