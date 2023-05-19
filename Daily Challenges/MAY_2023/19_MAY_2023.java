class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i<graph.length; i++) {
            if(color[i]==0 && !dfs(graph, i, color, 1))
                return false;
        }
        return true;
    }

    boolean dfs(int[][] graph, int i, int[] color, int curr) {
        if(color[i]!=0)
            return color[i]==curr;
        
        color[i] = curr;
        if(curr==1) curr = 2;
        else curr = 1;
        for(int nei : graph[i]) {
            if(!dfs(graph, nei, color, curr))
                return false;
        }
        return true;
    }
}
