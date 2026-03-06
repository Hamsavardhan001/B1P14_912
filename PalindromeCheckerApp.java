package PalindromeApps;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()){
            stk.push(c);
        }
        for(int i = 0; i < str.length() -1; i++){
            if(str.charAt(i) != stk.pop()) return;
        }

        System.out.println("Palindrome");
    }
}
