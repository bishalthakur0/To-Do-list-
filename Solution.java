import java.io.*;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        long result = Result.substringCalculator(s);
        System.out.println(result);
    }
}

class Result {
    public static long substringCalculator(String s) {
        // Base values for the rolling hash function
        int base = 31;
        int mod = 1_000_000_007;

        HashSet<Long> hashes = new HashSet<>();
        int n = s.length();

        // Calculate hash for every possible substring
        for (int i = 0; i < n; i++) {
            long hashValue = 0;
            long power = 1;

            // Generate all substrings starting at index i
            for (int j = i; j < n; j++) {
                hashValue = (hashValue * base + (s.charAt(j) - 'a' + 1)) % mod;
                hashes.add(hashValue);
            }
        }

        // Return the number of distinct hashes (distinct substrings)
        return hashes.size();
    }
}
