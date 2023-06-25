class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i] + 500;
                dp[j][diff] = dp[i][diff] + 1;
                ans = Math.max(ans, dp[j][diff]);
            }
        }
        return ans;
    }
