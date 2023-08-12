class Solution {
    int dp[][];
    private int countPaths(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = countPaths(i-1, j, grid) + countPaths(i, j-1, grid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countPaths(m-1, n-1, obstacleGrid);
    }
}
