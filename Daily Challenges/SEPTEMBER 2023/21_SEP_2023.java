class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
    
        int k = n/2;
        
        if(n % 2 == 1) {
            return solve(nums1, nums2, k, 0, n1-1, 0, n2-1);
        }
        else {
            return (double)(solve(nums1, nums2, k, 0, n1-1, 0, n2-1) + solve(nums1, nums2, k-1, 0, n1-1, 0, n2-1))/2;
        }
        
        
    }
    
    public int solve(int[] a, int[] b, int k, int a_start, int a_end, int b_start, int b_end) {
        
        if(a_start > a_end) {
            return b[k - a_start];
        }
        
        if(b_start > b_end) {
            return a[k - b_start];
        }
        
        int a_midIdx = a_start + (a_end - a_start)/2;
        int b_midIdx = b_start + (b_end - b_start)/2;
        
        int a_value = a[a_midIdx];
        int b_value = b[b_midIdx];
        
        // K is in second larger half so cut one smaller half
        if(a_midIdx + b_midIdx < k) {
            
            //cut smaller half of a
            if(a_value < b_value) {
                return solve(a, b, k, a_midIdx + 1, a_end, b_start, b_end);
            }
            else {
                return solve(a, b, k, a_start, a_end, b_midIdx + 1, b_end);
            }            
            
        }
        //K is smaller than mid indexes so K is in the smaller half of A+B sorted, so cut one larger half
        else {
            if(a_value < b_value) {
                return solve(a, b, k, a_start, a_end, b_start, b_midIdx - 1);
            }
            else {
                return solve(a, b, k, a_start, a_midIdx - 1, b_start, b_end);
            }
              
        }
      
        
    }
}
