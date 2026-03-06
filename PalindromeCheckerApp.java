package PalindromeApps;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String str = "malayalam";
        isPalindrome(str, 0);
    }

    public static void isPalindrome(String str, int lvl){
        if(lvl == str.length()/2){
            System.out.println("Palindrome");
            return;
        }

        if (str.charAt(lvl) == str.charAt(str.length() - (lvl + 1)))
            isPalindrome(str, ++lvl);
    }
}
