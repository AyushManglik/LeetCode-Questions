// Memoization
class Solution {
    public long mostPoints(int[][] q) {
        int n= q.length;
        long[] dp= new long[n+1];
        Arrays.fill(dp,-1);
        
        long max= 0;
        
        
        max= Math.max(max,solve(q,dp,0,n));
        
        
        return max;
    }
    
    public long solve(int[][] q, long[] dp, int i, int n){
        if(i>=n){
            return 0;
        }
        
        if(i==n-1){
            return q[i][0];
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        return dp[i]= Math.max(q[i][0]+solve(q,dp,i+q[i][1]+1,n),solve(q,dp,i+1,n));
    }
}

// OPTIMIZED
class Solution {
    public long mostPoints(int[][] questions) {
        
        long[] maxPoints = new long[questions.length + 1];
        {
            int index = 0;
            while (index < questions.length) {

                index++;
            }
        }

        long position;

        for (int index = questions.length - 1; index >= 0; index--) {
            int left = questions[index][1];
            int right = index + left + 1;

            if (right <= questions.length) {
                position = questions[index][0] + maxPoints[right];

            } else {
                position = questions[index][0];
            }

            maxPoints[index] = Math.max(maxPoints[index + 1], position);
        }

        return maxPoints[0];
    }
}
