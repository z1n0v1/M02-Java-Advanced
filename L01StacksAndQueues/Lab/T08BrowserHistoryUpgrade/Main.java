/*
    https://judge.softuni.org/Contests/Practice/Index/1437#7

    08. Browser History Upgrade

Extend "Browser History" with a "forward" instruction which visits URLs that were navigated away from by "back"
Each forward instruction visits the next most-recent such URL. If a normal navigation happens,
all potential forward URLs are removed until a new back instruction is given
If the forward instruction can’t be executed, print
"no next URLs".
 */

package L01StacksAndQueues.Lab.T08BrowserHistoryUpgrade;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String navigation = scanner.nextLine();

        String current = "";
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();


        while (!navigation.equals("Home")) {

            if (navigation.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    current = forward.poll();
                }
            } else {

                if (navigation.equals("back")) {
                    if (history.isEmpty()) {
                        System.out.println("no previous URLs");
                        navigation = scanner.nextLine();
                        continue;
                    } else {
//                        forward.offer(current);
                        forward.addFirst(current); // using queue as a stack !?
                        current = history.pop();

                    }
                } else {
                    if (!current.equals("")) {
                        history.push(current);
                        forward.clear();
                    }
                    current = navigation;
                }
            }
            System.out.println(current);
            navigation = scanner.nextLine();
        }

        /* Why not implement forward with a second stack ?
        while (!navigation.equals("Home")) {

            if (navigation.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    current = forward.pop();
                }
            } else {

                if (navigation.equals("back")) {
                    if (history.isEmpty()) {
                        System.out.println("no previous URLs");
                        navigation = scanner.nextLine();
                        continue;
                    } else {
//                        forward.offer(current);
                        forward.push(current);
                        current = history.pop();

                    }
                } else {
                    if (!current.equals("")) {
                        history.push(current);
                        forward.clear();
                    }
                    current = navigation;
                }
            }
            System.out.println(current);
            navigation = scanner.nextLine();
        }

         */
    }
}

