/*
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
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(0,result,nums);
        return result;
    }

    void recursion(int index,List<List<Integer>> result,int[] nums){
        if(index==nums.length-1){
            List<Integer> temp = new ArrayList<>();
            for(int x: nums) temp.add(x);
            result.add(temp);
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recursion(index+1,result,nums);
            swap(i,index,nums);
        }
    }

    void swap(int x,int y,int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
