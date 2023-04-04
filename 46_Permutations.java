class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        permutation(nums,0,list,ans);
        return ans; 
    }
    private static void permutation(int []nums,int idx,List<Integer> list,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            permutation(nums,idx+1,list,ans);
            list.remove(list.size()-1);
        }
    }
}
// TC : O(n!)
