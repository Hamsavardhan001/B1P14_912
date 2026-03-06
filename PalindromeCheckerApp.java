package PalindromeApps;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        Stack<Character> stk = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(char c : str.toCharArray()){
            stk.push(c);
            q.add(c);
        }
        for(int i = 0; i < str.length() -1; i++){
            if(str.charAt(i) != stk.pop()) return;
        }

        System.out.println("Palindrome using stk");

        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) != q.remove()) return;
        }

        System.out.println("Palindrome using Q");
    }
}
