// Beats 100%
class Solution {
    public int numWays(String[] words, String target) {
        int iLength = target.length();
        int jLength = words[0].length();
        long[][] ij = new long[iLength][jLength];

        int[][] charCounts = new int[jLength][26];

        for (String word : words) {
            for (int i = 0; i < jLength; i++) {
                charCounts[i][word.charAt(i) - 'a']++;
            }
        }


        for (int i=0; i < target.length(); i++) {
            char c = target.charAt(i);
            // calculate for all j's up to now
            int charsLeft = iLength - i - 1;
            for (int j=i; j < jLength - charsLeft; j++) {
                long matches = charCounts[j][c - 'a'];
                if (i > 0) {
                    matches = (matches * ij[i -1][j -1]) % 1000000007;
                }
                if (j > i) {
                    matches = (matches + ij[i][j - 1]) % 1000000007;
                }
                ij[i][j] = matches % 1000000007;
            }
        }
        return (int) ij[iLength -1][jLength -1];
    }
}

// Brute Fore
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Long[][] dp;
    private Map<Character, Integer>[] count;
    private int mod = 1000000007;

    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();

        // Initialize count map for each position in words
        count = new HashMap[m];
        for (int i = 0; i < m; i++) {
            count[i] = new HashMap<>();
        }

        // Count occurrences of characters in words
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                char c = word.charAt(i);
                count[i].put(c, count[i].getOrDefault(c, 0) + 1);
            }
        }

        // Initialize memoization array
        dp = new Long[n][m];

        // Call recursive helper function
        return (int) (dfs(target, 0, 0) % mod);
    }

    private long dfs(String target, int idx, int pos) {
        if (idx == target.length()) {
            return 1;
        }

        if (pos == count.length) {
            return 0;
        }

        if (dp[idx][pos] != null) {
            return dp[idx][pos];
        }

        char c = target.charAt(idx);
        long ans = dfs(target, idx, pos + 1) % mod;

        if (count[pos].containsKey(c)) {
            ans += (count[pos].get(c) * dfs(target, idx + 1, pos + 1) % mod) % mod;
        }

        dp[idx][pos] = ans % mod;
        return dp[idx][pos];
    }
}
