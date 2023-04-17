/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
       return isvalidBST2(root, null, null);
    }
    private boolean isvalidBST2(TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;
        if(low != null && root.val <= low)
            return false;
        if(high != null && root.val >= high)
            return false;
        Integer h = root.val,l = root.val;
        if(high != null && high < h)
            h = high;
          if(low != null && low > l)
            l = low;
        boolean left = isvalidBST2(root.left, low, h);
        boolean right = isvalidBST2(root.right, l ,high);
        return left && right;
    }
    
}
