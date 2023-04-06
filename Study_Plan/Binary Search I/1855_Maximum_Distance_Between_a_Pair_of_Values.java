class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j = nums2.length-1;
        int i = nums1.length-1;
        int max = 0;
        while(i>=0 && j>=0){
            if(nums2[j]>=nums1[i]){
                max = Math.max(max,j-i);
                i--;
            }else{
                j--;
            }
        }
        return max;
    }
}
