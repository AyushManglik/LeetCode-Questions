class Solution{
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int mod =1000000007;
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){// Iterate over the string from right to left
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            long res=0;
            for (int j = i; j < n; j++) {// Compute the number formed by the substring s[i:j+1]
                res=res*10+(s.charAt(j)-'0');
                if(res>k) break;  
                dp[i]=(dp[i]+dp[j+1])%mod;// Add the number of arrays formed by the substring s[j+1:]
            }
        }
        return dp[0];
    }
}
