// Binary Search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            if(target > matrix[row][col])
                row++;
            else
                col--;
        }
        return false;
    }
}




// Brute Force Approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
