//Approach - 1 (By Using DP Array)
class Solution {
    Integer dp[][];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new Integer[piles.size() +1][k+1];
        return knapSack(piles, piles.size()-1, k);
    }
    private int knapSack(List<List<Integer>> piles, int i, int k){
        if (i < 0 || k == 0){
            return 0;
        }
        if (dp[i][k] != null){
            return dp[i][k];
        }
        int n = Math.min(piles.get(i).size(), k);
        int exclude = knapSack(piles, i-1,k);

        int include = 0;
        for (int j = 0, sum = 0; j<n; j++){
            sum += piles.get(i).get(j);
            include = Math.max(sum + knapSack(piles, i-1, k-j-1), include);
        }
        int res = Math.max(include, exclude);
        dp[i][k] = res;
        return res;
    }
}

//Approach - 2 (By using PREFIX sum)
class Solution {
	public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int[] pilesSum = new int[k + 1];
		int[] mvoc = new int[k + 1];
		for (List<Integer> pile : piles) {
			int n = Math.min(k, pile.size());
			int sum = 0;
			for (int i = 1; i <= n; i++)
				pilesSum[i] = sum += pile.get(i - 1);
			for (int i = k; i > 0; i--) {
				int max = 0;
				for (int j = Math.min(i, n); j >= 0; j--)
					max = Math.max(max, pilesSum[j] + mvoc[i - j]);
				mvoc[i] = max;
			}
		}
		return mvoc[k];
	}
}
