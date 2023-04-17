/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // If the root is null, then there is no LCA, so return null.
        if(root == null){
            return root;
        }

        // Get the value of the current node.
        int cur = root.val;

        // If both p and q are greater than the current node, then the LCA is in the right subtree.
        if(cur < p.val && cur < q.val){
            return lowestCommonAncestor(root.right, p, q); // Recurse on the right subtree.
        }
        // If both p and q are less than the current node, then the LCA is in the left subtree.
        if(cur > p.val && cur > q.val){
            return lowestCommonAncestor(root.left, p, q); // Recurse on the left subtree.
        }
        // Otherwise, the current node is the LCA.
        return root;
    }
}

// Easy Solution to understand

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

       
        if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }else{
            return root;
        }
        

    }
}
  
