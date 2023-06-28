class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
          double[] dp = new double[n];
    dp[start] = 1;
    while (true) {
        boolean k = false;
        for (int j = 0; j < edges.length; j++) {
            if (dp[edges[j][0]] * succProb[j] > dp[edges[j][1]]) {
                dp[edges[j][1]] = dp[edges[j][0]] * succProb[j];
                k = true;
            }
            if (dp[edges[j][1]] * succProb[j] > dp[edges[j][0]]) {
                dp[edges[j][0]] = dp[edges[j][1]] * succProb[j];
                k = true;
            }
        }
        if (!k) break;
    }
    return dp[end];
    }
}
