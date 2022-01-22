/*
    https://judge.softuni.org/Contests/Practice/Index/1437#0

    01. Browser History

Write a program which takes 2 types of browser instructions:
•	Normal navigation: a URL is set, given by a string
•	The string "back" that sets the current URL to the last set URL
After each instruction the program should print the current URL. If the back instruction can’t be executed, print
"no previous URLs". The input ends with "Home" command, then simply you have to stop the program.

 */

package L01StacksAndQueues.Lab.T01BrowserHistory;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String navigation = scanner.nextLine();

        String current = "";


        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    current = history.pop();
                }
            } else {
                if (!current.equals(""))
                    history.push(current);
                current = navigation;
            }
            System.out.println(current);
            navigation = scanner.nextLine();
        }
    }
}
