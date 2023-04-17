class Solution{
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, h = (int)1e9;
        while(l < h) {
            int m = l + (h-l)/2;
            if(check(nums, m, maxOperations)) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    
    boolean check(int[] a, int m, int ops) {
        for(int e : a) {
            ops -= (e-1)/m;
            if(ops < 0) return false;
        }
        return true;
    }
}
