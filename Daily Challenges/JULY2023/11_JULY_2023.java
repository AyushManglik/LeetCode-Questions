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
    public void getAllNodesFromK(TreeNode root,int k,List<Integer> res){
        if(root==null){
            return ;
        }
        if(k==0){
            res.add(root.val);
            return ;
        }
        getAllNodesFromK(root.left,k-1,res);
        getAllNodesFromK(root.right,k-1,res);

         
    }
    public int solve(TreeNode root, TreeNode target, int k,List<Integer> res){
        if(root==null){
            return -1;
        }
        if(root==target){
            getAllNodesFromK(root,k,res);
            return 1;
        }
        int left = solve(root.left,target,k,res);
        int right = solve(root.right,target,k,res);
        if(left!=-1 && left<=k){
            if(left==k){
                res.add(root.val);
            }
            else{
                getAllNodesFromK(root.right,k-left-1,res);
            }
            return 1+left;
        }
        if(right!=-1 && right<=k){
            if(right==k){
                res.add(root.val);
            }
            else{
                getAllNodesFromK(root.left,k-right-1,res);
            }
            return 1+right;
        }
        return -1;

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        solve(root,target,k,res);
        return res;
    }
}
