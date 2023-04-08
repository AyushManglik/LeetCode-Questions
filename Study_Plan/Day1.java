class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int last = 0;
        int min = Integer.MAX_VALUE;
        if (nums == null || n == 0){
            return 0;
        }
        for (int i=0; i< n; i++){
            totalSum+=nums[i];
                while(totalSum>=target){
                    min = Math.min(min,i+1-last);
                    totalSum -= nums[last];
                    last++;
                }
        }
        return (min == Integer.MAX_VALUE ? 0 : min);
    }
}
