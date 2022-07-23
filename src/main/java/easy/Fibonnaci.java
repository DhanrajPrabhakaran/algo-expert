package easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonnaci {
    public static void main(String[] args) {
        System.out.println("Fibonacci: " + getFib(6));
        System.out.println("Fibonacci: " + getFibRec(6));
        System.out.println("Fibonacci: " + getFibSpace(6));

    }
    // O(n) time | O(1) space
    private static int getFibSpace(int n) {
        int first = 0;
        int second = 1;
        int counter = 3;
        while (counter <= n) {
            int next = first + second;
            first = second;
            second = next;
            counter++;
        }
        return n > 1 ? second : first;
    }
    // O(2^n) time | O(n) space
    private static int getFibRec(int n) {
        if (n == 1 || n == 2)
            return n - 1;
        return getFibRec(n - 1) + getFibRec(n - 2);
    }
    // O(n) time | O(n) space
    private static int getFib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fib(n, memo);
    }

    private static int fib(int n, Map<Integer, Integer> memo) {
        if (n == 1 || n == 2)
            return n - 1;
        if (memo.containsKey(n))
            return memo.get(n);
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }
}
