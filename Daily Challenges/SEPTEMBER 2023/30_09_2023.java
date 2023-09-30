/*
import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;
        int[] minLeft = new int[n];
        minLeft[0] = nums[0];

        // Find the minimum element on the left for each position.
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int j = n - 1; j >= 0; j--) {
            // Check if the current element is greater than the minimum on the left.
            if (nums[j] > minLeft[j]) {
                // We found a potential '2'.
                while (!stack.isEmpty() && stack.peek() <= minLeft[j]) {
                    stack.pop(); // Remove elements <= minLeft[j]
                }
                // If we find an element greater than minLeft[j], it's a valid '3'.
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                // Push the current element as a potential '3'.
                stack.push(nums[j]);
            }
        }

        return false;
    }
}
*/
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MIN_VALUE;
        int peak = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) return true;
            while (peak < nums.length && nums[i] > nums[peak]) {
                min = nums[peak++];
            }         
            peak--;
            nums[peak] = nums[i];
        }
        return false;
    }
}
