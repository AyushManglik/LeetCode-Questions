// Approach - 1     --> Using HashSet O(n) && O(n)
/*
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = 0;
        for (int i=0; i<nums.length; i++){
            if(!set.add(nums[i])){
                repeat = nums[i];
            }
        }
        return repeat;
   }
}
*/

// Approach - 2        --> Sorting and then finding.

/*
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int repeat = 0;
        for (int i=1; i<nums.length; i++){
            if (nums[i] == nums[i-1]){
                repeat = nums[i];
            }
        }
        return repeat;
   }
}
*/

// Approach - 3     --> Visited Array (true/false)

class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        //int repeat = 0
        for (int i : nums) {
            if (visited[i] == false) {
                visited[i] = true;
            } else {
                return i;
            }
        }
        return -1;
    }
}
