package PalindromeApps;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        String str = "malayalam";
        String str1 = new String();
        for(int i = str.length()-1 ; i >= 0; i--){
            str1+=str.charAt(i);
        }
        System.out.println(str1.equals(str));
    }
}
