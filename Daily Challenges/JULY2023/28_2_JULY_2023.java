class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] arr=new int[n];
        for(int p1=n-1;p1>=0;--p1)
        {  
            arr[p1]=nums[p1];
            for(int p2=p1+1;p2<n;p2++)
            {
                arr[p2]=Math.max(nums[p1]-arr[p2],nums[p2]-arr[p2-1]);
            }
        }
        return arr[n-1]>=0;
    }
}
