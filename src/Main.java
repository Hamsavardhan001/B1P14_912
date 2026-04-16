import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based approach
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based approach
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : input.toCharArray()) dq.addLast(c);

        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) return false;
        }
        return true;
    }
}

// Two-pointer (optimized O(1) space)
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i++) != input.charAt(j--)) return false;
        }
        return true;
    }
}

// Benchmark Runner
class Benchmark {

    public static void run(String name, PalindromeStrategy strategy, String input, int iterations) {

        // warm-up (avoids JVM bias)
        for (int i = 0; i < 1000; i++) {
            strategy.isPalindrome(input);
        }

        long start = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            strategy.isPalindrome(input);
        }

        long end = System.nanoTime();

        long avgTime = (end - start) / iterations;

        System.out.println(name + " -> Avg Time: " + avgTime + " ns");
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        String input = "madamimadamracecarlevelmadamimadam";
        int iterations = 100000;

        PalindromeStrategy stack = new StackStrategy();
        PalindromeStrategy deque = new DequeStrategy();
        PalindromeStrategy twoPointer = new TwoPointerStrategy();

        System.out.println("=== Palindrome Performance Benchmark ===");

        Benchmark.run("Stack Strategy", stack, input, iterations);
        Benchmark.run("Deque Strategy", deque, input, iterations);
        Benchmark.run("Two Pointer Strategy", twoPointer, input, iterations);
    }
}