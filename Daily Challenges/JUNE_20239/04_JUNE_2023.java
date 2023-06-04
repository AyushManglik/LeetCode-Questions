class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean [] vis=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int[][] isConnected,boolean [] vis,int i){
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }
    }
}
