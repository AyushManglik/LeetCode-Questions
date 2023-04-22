class Solution {
    public int minInsertions(String str) {
        int len = str.length();
        int[] dp = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int prev = 0;
            for (int j = i + 1; j < len; j++) {
                int temp = dp[j];
                if (str.charAt(i) == str.charAt(j)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + 1;
                }
                prev = temp;
            }
        }
        return dp[len-1];
    }
}
