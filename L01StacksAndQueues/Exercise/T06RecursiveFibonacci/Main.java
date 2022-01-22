/*
    https://judge.softuni.org/Contests/Compete/Index/1442#5

    06. Recursive Fibonacci

Each member of the Fibonacci sequence is calculated from the sum of the two previous members.
The first two elements are 1, 1. Therefore the sequence goes as 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that’s easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the nth Fibonacci number,
we can express it using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
However, this will never end and in a few seconds a Stack Overflow Exception is thrown.
In order for the recursion to stop it has to have a "bottom". The bottom of the recursion is getFibonacci(1),
and should return 1. The same goes for getFibonacci(0).

Input
•	On the only line in the input the user should enter the wanted Fibonacci number N where 1 ≤ N ≤ 49

Output
•	The output should be the nth Fibonacci number counting from 0

 */

package L01StacksAndQueues.Exercise.T06RecursiveFibonacci;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    private static LinkedHashMap<Long, Long> cache;
    public static void main(String[] args) {
        cache = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        long fibonacciNum = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(fibonacciNum));
//        System.out.println(cache);
    }
    private static Long getFibonacci(Long number) {
        if(number == 1L || number == 0L) return 1L;
        if(cache.containsKey(number)) {
//            System.out.printf("Cached %d %d", number, cache.get(number));
            return (Long) cache.get(number);
        } else {
            long result = getFibonacci(number-1) + getFibonacci(number -2);
            cache.put(number, result);
//            System.out.printf("Cache %d %d%n", number, result);
            return result;
        }

    }
}
