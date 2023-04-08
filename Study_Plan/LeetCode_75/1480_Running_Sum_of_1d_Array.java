class Solution {
    public int[] runningSum(int[] nums) {
        //base conditions if the array is empty.
        if (nums == null || nums.length == 0){
            return nums;
        }
        //if array is not empty.
      
      // by for loop
        for (int i=1; i< nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
      
      // by while loop
        int i=1;
        while(i < nums.length) {
            nums[i] = nums[i-1] + nums[i];
            i++;
        }
        return nums;
    }
}
