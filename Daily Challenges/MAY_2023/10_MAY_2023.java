// 59. Spiral Matrix II (BEATS 100%)
class Solution {
    public int[][] generateMatrix(int n) {
        int x = 1,cnt = 0;
        int[][] ans = new int[n][n];
        int[][] visited = new int[n][n];
        int i = 0,j = 0,k = 0;
        while(cnt < (n * n)){
            if(visited[i][j] == 0){
                ans[i][j] = x++;
                visited[i][j] = 1;
                if(i == k && j < n - 1 - k) j++;
                else if(j == n - 1 - k && i < n - 1 - k) i++;
                else if(i == n - 1 - k && j <= n - 1 - k && j != k) j--;
                else if(i <= n - 1 - k && j == k) i--;
                cnt++;
            }else{ 
                k++;
                i++;
                j++;
            }
        }
        return ans;
    }
}
