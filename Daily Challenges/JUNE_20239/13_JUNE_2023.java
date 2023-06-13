
class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length; // Get the size of the grid (assuming it's a square grid)
        long[] rowSums = new long[n]; // Create an array to store the sums of rows
        long[] colSums = new long[n]; // Create an array to store the sums of columns

        // Calculate row sums
        for (int i = 0; i < n; i++) { // Iterate through each row
            long sum = 0;
            for (int j = 0; j < n; j++) { // Iterate through each element in the row
                sum = sum * 10 + grid[i][j]; // Calculate the sum of the row using base 10 arithmetic
            }
            rowSums[i] = sum; // Store the sum of the row in the rowSums array
        }

        // Calculate column sums
        for (int i = 0; i < n; i++) { // Iterate through each column
            long sum = 0;
            for (int j = 0; j < n; j++) { // Iterate through each element in the column
                sum = sum * 10 + grid[j][i]; // Calculate the sum of the column using base 10 arithmetic
            }
            colSums[i] = sum; // Store the sum of the column in the colSums array
        }

        int count = 0; // Initialize a counter for equal row and column pairs

        // Count equal row and column pairs
        for (int i = 0; i < n; i++) { // Iterate through each row
            for (int j = 0; j < n; j++) { // Iterate through each column
                if (rowSums[i] == colSums[j]) { // Compare the sum of the current row with the sum of the current column
                    count++; // If they are equal, increment the count
                }
            }
        }

        return count; // Return the count of equal row and column pairs
    }
}
