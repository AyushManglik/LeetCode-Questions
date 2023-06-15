
class Solution {
    public int maxLevelSum(TreeNode root) {
       int maxLevel = 1;
       int level = 1;
       int maxSum = root.val;
       Queue<TreeNode> pq = new LinkedList<>();
       pq.offer(root);

       while(!pq.isEmpty()){
           int size = pq.size();
           int levelSum = 0;

           for (int i=0; i<size; i++){

               TreeNode node = pq.poll();
               levelSum = levelSum + node.val;

               if (node.left != null){
                   pq.offer(node.left);
               }
               if(node.right != null){
                   pq.offer(node.right);
               }
           }
           if (levelSum > maxSum){
               maxSum = levelSum;
               maxLevel = level;
           }
           level++;
       }
       return maxLevel;
    }
}
