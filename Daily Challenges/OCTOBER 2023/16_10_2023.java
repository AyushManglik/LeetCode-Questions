//approach - 1 // chatGPT

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Add the first element to the row
        row.add(1);
        
        // Generate the row using the previous row
        for (int i = 1; i <= rowIndex; i++) {
            // Calculate the value of the current element using the previous element and the formula (n, k) = (n-k+1)/k * (n, k-1)
            int curr = (int)((long)row.get(i-1) * (rowIndex - i + 1) / i);
            row.add(curr);
        }
        
        return row;
    }
}
