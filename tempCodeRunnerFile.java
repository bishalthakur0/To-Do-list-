import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String s = scanner.nextLine();
        
        System.out.println("Number of distinct palindromic substrings: " + Result.palindrome(s));
    }
}

class Result {
    /*
     * Complete the 'palindrome' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int palindrome(String s) {
        HashSet<String> uniquePalindromes = new HashSet<>();

        // Expand around each possible center
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            expandAroundCenter(s, i, i, uniquePalindromes);
            // Even-length palindromes
            expandAroundCenter(s, i, i + 1, uniquePalindromes);
        }

        return uniquePalindromes.size();
    }

    private static void expandAroundCenter(String s, int left, int right, HashSet<String> uniquePalindromes) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            uniquePalindromes.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }
}
