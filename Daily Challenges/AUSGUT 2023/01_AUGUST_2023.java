class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, ans, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int n, int k, List<List<Integer>> ans, List<Integer> temp) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        } else if (n < 1) {
            return;
        } 

        temp.add(n);
        helper(n-1, k-1, ans, temp);
        temp.remove(temp.size() - 1);
        
        // trimming
        if (k <= n-1) {
            helper(n-1, k, ans, temp);
        }
    
        return;

    }
}
