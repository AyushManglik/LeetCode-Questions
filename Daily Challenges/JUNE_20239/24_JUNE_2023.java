class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = Arrays.stream(rods).sum();
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int rod : rods) {
            int[] curr = dp.clone();
            for (int diff = 0; diff <= sum - rod; diff++) {
                if (curr[diff] >= 0) {
                    dp[diff + rod] = Math.max(dp[diff + rod], curr[diff]);
                    dp[Math.abs(diff - rod)] = Math.max(dp[Math.abs(diff - rod)], curr[diff] + Math.min(diff, rod));
                }
            }
        }

        return dp[0];
    }
}
