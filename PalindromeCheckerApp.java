package PalindromeApps;


import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        Deque<Character> dq = new ArrayDeque<Character>();
        for(char c : str.toCharArray()){
            dq.add(c);
        }
        for(int i = 0; i < (str.length() -1)/2; i++){
            char a = dq.removeFirst();
            char b = dq.removeLast();
            if (a!=b) return;
        }

        System.out.println("Palindrome using DQ");

    }
}
