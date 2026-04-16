import java.util.*;

// 1. Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// 2. Stack-based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// 3. Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// 4. Context Class (Strategy Injector)
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }

        input = input.replaceAll("\\s+", "").toLowerCase();
        return strategy.isPalindrome(input);
    }
}

// 5. Main Class
public class Main {

    public static void main(String[] args) {

        PalindromeContext context = new PalindromeContext();

        String input = "racecar";

        // Strategy 1: Stack
        context.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy: " + context.check(input));

        // Strategy 2: Deque
        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: " + context.check(input));

        // Try another input
        String input2 = "hello";

        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy (hello): " + context.check(input2));
    }
}