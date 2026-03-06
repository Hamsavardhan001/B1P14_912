package PalindromeApps;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        int i = 0; int j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return;
            i++; j--;
        }
        System.out.println("Palindrome");
    }
}
