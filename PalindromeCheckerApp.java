package PalindromeApps;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while(i<j){
            if(chars[i] != chars[j]) return;
            i++;
            j--;
        }

        System.out.println("Palindrome");
    }
}
