/*
    https://judge.softuni.org/Contests/Compete/Index/1442#9

    10. Robotics

Somewhere in the future, there is a robotics factory. The current project is assembly line robots.
Each robot has a processing time, the time it needs to process a product.
When a robot is free it should take a product for processing and log his name, product and processing start time.
Each robot processes a product coming from the assembly line.
A product is coming from the line each second (so the first product should appear at [start time + 1 second]).
If a product passes the line and there is not a free robot to take it, it should be queued at the end of the line again.
The robots are standing on the line in the order of their appearance.

Input
•	On the first line, you will get the names of the robots and their processing times in format "robotName-processTime;robotName-processTime;robotName-processTime"
•	On the second line, you will get the starting time in format "hh:mm:ss"
•	Next, until the "End" command, you will get a product on each line.
 */

package L01StacksAndQueues.Exercise.T10T2R100Robotics;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static LinkedHashMap<String, Integer> robots;
    static LinkedHashMap<String, Integer> robotsWorkingTime;
    static LinkedHashMap<String, String> currentDetails;
    static ArrayDeque<String> detailsQueue;
    static int currentTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        robots = new LinkedHashMap<>();
        robotsWorkingTime = new LinkedHashMap<>();
        currentDetails = new LinkedHashMap<>();
        detailsQueue = new ArrayDeque<>();

        String[] robotsStringData = scanner.nextLine().split(";");
        for (String robotsStringDatum : robotsStringData) {
            String[] data = robotsStringDatum.split("-");
            robots.put(data[0], Integer.parseInt(data[1]));
            robotsWorkingTime.put(data[0], 0);
            currentDetails.put(data[0], "");
        }
        currentTime = currentTimeToSeconds(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            detailsQueue.offer(input);
            input = scanner.nextLine();
        }

        while (!detailsQueue.isEmpty()) {
            currentTime++;
            robotsDoWork();
            robotsWorkingCycle();
        }

    }

    private static void robotsWorkingCycle() {
        String currentDetail = detailsQueue.poll();
        boolean detailAdded = false;
        for (Map.Entry<String, Integer> currentRobot : robotsWorkingTime.entrySet()) {
            if(currentRobot.getValue() == 0) {
                robotsWorkingTime.put(currentRobot.getKey(),robots.get(currentRobot.getKey()));
                System.out.printf("%s - %s [%s]%n",
                        currentRobot.getKey(), currentDetail, timeInSecondsToString(currentTime));
                detailAdded = true;
                break;
            }
        }
        if(!detailAdded && currentDetail != null) detailsQueue.offer(currentDetail);
    }

    private static void robotsDoWork() {
        for (Map.Entry<String, Integer> robotTime : robotsWorkingTime.entrySet()) {
            if(robotTime.getValue() > 0) {
                robotsWorkingTime.put(robotTime.getKey(), robotTime.getValue() - 1);
            }
        }
    }

    private static String timeInSecondsToString(int timeInSeconds) {
        int hour = timeInSeconds / 3600;
        int minutes = (timeInSeconds % 3600) / 60;
        int seconds = ((timeInSeconds % 3600) % 60);

        while (hour > 23) hour -= 24;

        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }

    private static int currentTimeToSeconds(String time) {
        String[] data = time.split(":");
        int hour = Integer.parseInt(data[0]);
        int minutes = Integer.parseInt(data[1]);
        int seconds = Integer.parseInt(data[2]);

        return hour * 3600 + minutes * 60 + seconds;
    }
}
