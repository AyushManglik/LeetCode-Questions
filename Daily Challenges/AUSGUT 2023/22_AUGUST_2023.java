class Solution {
    public String convertToTitle(int columnNumber) {
        // I use StringBuilder as it is very easy to perform the operation on the string
        StringBuilder ans = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber--;
            // Get the last character and append it at the end of the string.
            // ans.append((char)((columnNumber) % 26 + 'A'));
            ans.append((char)('A' + (columnNumber) % 26)); // it is also appending at the end only
            columnNumber = (columnNumber) / 26;
        }
        
        // Reverse it, as we appended characters in reverse order.
        return ans.reverse().toString();

        // return ans.toString();
    }
}
