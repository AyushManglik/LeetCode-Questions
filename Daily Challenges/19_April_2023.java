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
class Solution {
    static int maxLen = 0;
    private int[] longestZigZag_helper(TreeNode root) {
        if (root == null)
            return new int[] {-1,-1,-1};
        int[] left = longestZigZag_helper(root.left);
        int[] right = longestZigZag_helper(root.right);

        maxLen = Math.max(Math.max(left[1] + 1, right[0] + 1), Math.max(left[2], right[2]));
        return new int[]{left[1] + 1,right[0] + 1,maxLen};
    }
    public int longestZigZag(TreeNode root) {
        longestZigZag_helper(root);
        return maxLen;
    }
}
