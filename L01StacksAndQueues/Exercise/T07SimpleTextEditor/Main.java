/*
    https://judge.softuni.org/Contests/Compete/Index/1442#6

    07. Simple Text Editor

You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
•	"1 [string]" - appends [string] to the end of the text
•	"2 [count]" - erases the last [count] elements from the text
•	"3 [index]" - returns the element at position [index] from the text
•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation

Input
•	The first line contains N, the number of operations, where 1 ≤ N ≤ 105
•	Each of the following N lines contains the name of the operation, followed by the command argument,
if any, separated by space in the following format "command argument".
•	The length of the text will not exceed 1000000
•	All input characters are English letters
•	It is guaranteed that the sequence of input operation is possible to perform

Output
•	For each operation of type "3" print a single line with the returned character of that operation.

 */

package L01StacksAndQueues.Exercise.T07SimpleTextEditor;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> back = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(data[0]);
            switch (command) {
                case 1:
                    back.push(text.toString());
                    text.append(data[1]);
                    break;
                case 2:
                    back.push(text.toString());
                    int count = Integer.parseInt(data[1]);
                    text.delete(text.length() - count, text.length());
                    break;
                case 3:
                    int index = Integer.parseInt(data[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case 4:
                    text = new StringBuilder(back.pop());
                    break;
            }
        }
    }
}
