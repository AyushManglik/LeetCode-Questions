// brute force logic --> traversing all the elements one by one.
/*
class Solution {
    public boolean search(int[] nums, int target) {
        for (int i=0; i<nums.length;i++){
            if (nums[i] == target){
                return true;
            }
        }
        return false;
    }
}
*/

// optimized logic Binary Search

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1; 
                else 
                    low = mid + 1;
            } else if (nums[low] > nums[mid]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else 
                    high = mid - 1;
            } else {  // skip the duplicate and move 'lo' up
                low++;
            }
        }

        return false;
    }
}
