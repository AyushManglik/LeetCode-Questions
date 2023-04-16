/*

// Brute Force Approach --> Two Pointers i,j
class Solution {
    public int singleNonDuplicate(int[] nums) {
        for (int i=0; i<nums.length-1;){
            for (int j=i+1; j<nums.length;){
                if (nums[i] == nums[j]){
                    i += 2;
                    j += 2;
                }
                else{
                    return nums[i];
                }
            }
        }
        return nums[nums.length-1];
    }
}

*/
// O(log n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int l = 0;
        int h = nums.length-1;
        while(l<h) {
            int mid = l+(h-l)/2;
            if(nums[mid]==nums[mid+1]){
                mid = mid-1;
            } 
            if((mid-l+1)%2!=0){
                h = mid;
            }
            else{
                l = mid+1;
            }
        }
        
        return nums[l];
    }
}
