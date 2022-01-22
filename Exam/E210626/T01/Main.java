package Exam.E210626.T01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> tasks = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> threads = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int taskToKill = Integer.parseInt(reader.readLine());

        int killerThread = 0;
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int task = tasks.pollLast();
            if(task == taskToKill) {
                killerThread = threads.peekFirst();
                break;
            }
            int thread = threads.pollFirst();

            if(thread < task) {
                tasks.addLast(task);
                continue;
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", killerThread, taskToKill);
        for (int thread : threads)
            System.out.printf("%d ", thread);


    }
}
