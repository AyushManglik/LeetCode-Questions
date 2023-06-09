class Solution {
    /*Map<Integer,Integer>map;
    int find(int n){
        if(map.containsKey(n))
            return map.get(n);
        if(n<=3)
            return n;
        int min=10000;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+find(n-i*i));
        }
        map.put(n,min);
        return min;
    }
    public int numSquares(int n) {
        map=new HashMap<>();
        return find(n);
    }*/
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i=1; i<=n; i++){
            for (int j=1;j*j<=i; j++){
                if (i-j*j >=0){
                    dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
