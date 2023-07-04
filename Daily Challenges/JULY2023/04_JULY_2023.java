class Solution {
    public int singleNumber(int[] nums) {
        int o=0;
        int t=0;
        for(int i=0;i<nums.length;i++)
        {
            o=(nums[i]^o)&~t;
            t=(nums[i]^t)&~o;
        }
        return o;
    }
}
