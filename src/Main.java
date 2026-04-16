import java.util.Stack;

class PalindromeChecker {

    // Encapsulated logic: hidden from outside
    private boolean isPalindromeUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare with original string
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Public API (Single Responsibility Principle)
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Optional normalization (case-insensitive check)
        input = input.replaceAll("\\s+", "").toLowerCase();

        return isPalindromeUsingStack(input);
    }
}

public class Main {

    public static void main(String[] args) {

        PalindromeChecker checker = new PalindromeChecker();

        String input1 = "racecar";
        String input2 = "hello";
        String input3 = "Madam";

        System.out.println(input1 + " -> " + checker.checkPalindrome(input1));
        System.out.println(input2 + " -> " + checker.checkPalindrome(input2));
        System.out.println(input3 + " -> " + checker.checkPalindrome(input3));
    }
}