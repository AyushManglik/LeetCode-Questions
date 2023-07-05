/*    MEMORY EFFICIENT
class Solution {
    public int longestSubarray(int[] nums) {
        if (nums.length <= 0) return 0;
        int left = 0;
        int right = 0;
        int zeros = 1;

        while (right < nums.length) {
            if (nums[right] == 0) zeros--;
            if (zeros < 0) {
                if (nums[left] == 0) zeros++;
                left++;
            }
            right++;
        }
        System.gc();
        return right - left - 1;
    }
}
*/
/*    RUNTIME EFFICIENT
class Solution {
    public int longestSubarray(int[] nums) {
        int prevZeroPos = -1;
        int currZeroPos = findNextZeroPosition(0, nums);
        if (currZeroPos == nums.length) return nums.length - 1;

        int longestSeq = 0;
        while (currZeroPos != nums.length) {
            int nextZeroPos = findNextZeroPosition(currZeroPos + 1, nums);
            int seq = (currZeroPos - prevZeroPos - 1) + (nextZeroPos - currZeroPos - 1);
            if (seq > longestSeq) {
                longestSeq = seq;
            }
            prevZeroPos = currZeroPos;
            currZeroPos = nextZeroPos;
        }
        return longestSeq;
    }

    int findNextZeroPosition(int from, int[] arr) {
        for (int i = from; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return arr.length;
    }
}
*/
