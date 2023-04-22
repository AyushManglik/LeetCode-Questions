class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Integer dp[][][] = new Integer[101][101][101];
        return find(n,minProfit,group,profit,0,dp);
    }
    public int find(int a,int pro,int g[],int p[],int n,Integer dp[][][]){
        if(n>=p.length) return pro==0?1:0;
        if(dp[n][a][pro]!=null) return dp[n][a][pro];
        long ret = 1L*find(a,pro,g,p,n+1,dp),cal = 0L;
        if(a>=g[n]) cal = find(a-g[n],Math.max(pro-p[n],0),g,p,n+1,dp);
        long sum = (cal+ret)%1000000007;
        return dp[n][a][pro] = (int)sum;
    }
}
