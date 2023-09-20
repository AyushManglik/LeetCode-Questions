class Solution {
    public int minOperations(int [] nums,int x){
        int n = nums.length;
        int sum = 0;
        for(int i : nums)sum += i;
        int target = sum - x;
        int j = 0;
        int min = Integer.MIN_VALUE;
        sum = 0;
        for(int i = 0;i < n; i++){
            sum += nums[i];
            while(j <= i && sum > target){
                sum -= nums[j];
                j++;
            }
            if(sum == target){
                min = Math.max(min,i-j+1);
            }
        }
        if(min == Integer.MIN_VALUE)return -1;
        return n-min;
    }
}
