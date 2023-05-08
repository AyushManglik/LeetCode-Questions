class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<mat[0].length; j++){
                if((i==j) && (i+j == n-1)){
                    sum += mat[i][j];
                }
                else if((i==j) || (i+j == n-1)){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}

// OPTIMIZED

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0, end=mat.length -1; i<mat.length; i++, end--) {
            sum += mat[i][i] + mat[i][end];
            if (i == end)
                sum -= mat[i][end];
        }
        return sum;
    }
}
