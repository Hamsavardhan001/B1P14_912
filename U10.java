package PalindromeApps;

public class U10 {
    public static void main(String[] args){
        String str = "A man a plan a canal panama";
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            if(c == ' ') continue;
            sb.append(Character.toLowerCase(c));
        }
        for(char c : sb.toString().toCharArray()) System.out.print(c);
        System.out.println(" ");
        isPalindrome(sb.toString(), 0);

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
