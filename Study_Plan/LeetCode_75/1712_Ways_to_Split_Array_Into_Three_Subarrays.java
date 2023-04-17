class Solution {
    public int waysToSplit(int[] nums) {
        int total = 0, n = nums.length;
        for (int num: nums)
            total+=num;
        
        // If there are less than three numbers, there is no way to split the array.
        if(n <= 2)
            return 0;
        
        int modulo = (int)1e9+7;
        int ways = 0;
        int leftSum = 0, mid = nums[0], rightSum = nums[0]+nums[1];
        int i=0, j=1, k=2;
        while(i<n){
            // Increment left sum and move i pointer.(that make leftSum)
            leftSum += nums[i++];

            // Move j pointer until mid sum is less than or equal to twice left sum.
            //meaning make midSum untill sufficient amount is reached >leftSum*2
            //leftSum*2 bcz we are not seprating sums by index we are geeting continous sum
            while(j<n && (mid < (leftSum<<1) || j == i))
                mid += nums[j++];
            
            // If j reaches the end or mid sum is greater than twice the remaining sum, break out of the loop.
            if(j == n || 3*mid > 2*total)
                break;
            
            // Move k pointer until rightSum is less than or equal to the remaining sum.
            //now make rightSum from remainig eles
            while(k<n && total-rightSum >= rightSum-leftSum){
                rightSum += nums[k++];
            }

            // Add the number of valid splits to the total number of ways.
            ways += k-j;
            ways %= modulo;
        }

        return ways;
    }
}
