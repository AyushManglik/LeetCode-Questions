//Code (Optimized Logic -> Two pointers)


// This is beating 100%
// Optimized

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 1; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(nums[j-i]+nums[j]==target){
                    return new int[]{j-i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}


//Code (Brute Force -> With HASHMAP)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
