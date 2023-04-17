//(Bottom-UP Approach)
class Solution {
    public int fib(int n) {
        if(n==0){
           return 0;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
            
        }
        return dp[n];
    }
}
//(BruteForce/Simple)
class Solution {
    public int fib(int n) {
        if(n<=1){
           return n;
        }
        if(n==2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
