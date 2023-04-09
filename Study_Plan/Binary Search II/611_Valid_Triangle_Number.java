class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i>=2; i-- ){
            int low = 0, high = i-1;
            while(low < high){
                if (nums[low] + nums[high] > nums[i]){
                    result += (high - low);
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return result;
    }
}
