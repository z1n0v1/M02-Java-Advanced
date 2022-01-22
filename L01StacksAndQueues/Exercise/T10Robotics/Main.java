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

package L01StacksAndQueues.Exercise.T10Robotics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Robot> robots;
    static ArrayDeque<String> processingQueue;
    static int currentTimeInSeconds, workingRobots;

    private static class Robot {
        String name;
        int processingTime;
        int workingTimeToProcess;
        String product;

        public Robot(String name, int processingTime) {
            this.name = name;
            this.processingTime = processingTime;
            workingTimeToProcess = 0;
            product = "";
        }

        boolean isFree() {
            return workingTimeToProcess == 0;
        }

        public String getName() {
            return name;
        }

        public String getProduct() {
            return product;
        }

        String tick() {
            if (workingTimeToProcess > 0)
                workingTimeToProcess--;
            if (workingTimeToProcess == 0 && product.length() > 0) {
                String processedProduct = product;
                product = "";
                return processedProduct;
            }
            return null;
        }

        public boolean process(String product) {
            if (this.product.length() == 0 && workingTimeToProcess == 0) {
                this.product = product;
                workingTimeToProcess = processingTime;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        robots = new ArrayList<>();
        processingQueue = new ArrayDeque<>();

        String[] robotString = scanner.nextLine().split(";");
        for (String readRobot : robotString) {
            String[] robotData = readRobot.split("-");
            String robotName = robotData[0];
            int processingTime = Integer.parseInt(robotData[1]);
            robots.add(new Robot(robotName, processingTime));
        }
        currentTimeInSeconds = convertTimeToSeconds(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            processingQueue.offer(input);
            input = scanner.nextLine();
        }
        workingRobots = 0;
        do {
            currentTimeInSeconds++;
            processProduct();
        } while (workingRobots > 0);
    }

    private static void processProduct() {

        for (Robot robot : robots) {
            String processedProduct = robot.tick();
            if (processedProduct != null) {
//                System.out.printf("%s - %s [%s]%n", robot.getName(), processedProduct, getCurrentTime());
                workingRobots--;
            }
        }
        if(!processingQueue.isEmpty()) {
            String productToProcess = processingQueue.poll();

            for (Robot robot : robots) {
                if (robot.process(productToProcess)) {
                    System.out.printf("%s - %s [%s]%n", robot.getName(), robot.getProduct(), getCurrentTime());
                    workingRobots++;
                    return;
                }
            }
            processingQueue.offer(productToProcess);
        }

//        for (Robot robot : robots) {
//            if(!robot.getProduct().equals(""))
//        }
//        if(productToProcess != null)

    }

    private static String getCurrentTime() {
        int time = currentTimeInSeconds;
        int hour = time / (60 * 60);
        time -= hour * 60 * 60;
        int minutes = time / 60;
        int seconds = time - minutes * 60;
        if (hour > 23)
            hour -= 24;
        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }


    private static int convertTimeToSeconds(String time) {

        String[] timeString = time.split(":");
        int hours = Integer.parseInt(timeString[0]);
        int minutes = Integer.parseInt(timeString[1]);
        int seconds = Integer.parseInt(timeString[2]);

        return hours * 60 * 60 + minutes * 60 + seconds;
    }
}
