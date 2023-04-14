class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        return levelorder (root , res , 0);
    }
     public List<List<Integer>> levelorder(TreeNode node , List<List<Integer>> res , int depth) {
         if (node == null) {
             return res;
         }
         if (res.size() == depth) {
           res.add(new LinkedList<Integer>());
         }
         res.get(depth).add(node.val);  
         depth++;
         levelorder (node.left , res , depth);
         levelorder (node.right , res , depth);
         return res;
}
}
