class Solution {
    private int[] a, b, memo;
    private int m;

    public int makeArrayIncreasing(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        Arrays.sort(b);
        for (int i = 1; i < b.length; ++i)
            if (b[m] != b[i])
                b[++m] = b[i];
        ++m;
        int n = a.length;
        memo = new int[n + 1]; 
        int ans = dfs(n);
        return ans < 0 ? -1 : n + 1 - ans;
    }

    private int dfs(int i) {
        if (memo[i] != 0) return memo[i];
        int x = i < a.length ? a[i] : Integer.MAX_VALUE;
        int k = lowerBound(b, m, x);
        int res = k < i ? Integer.MIN_VALUE : 0;
        if (i > 0 && a[i - 1] < x) 
            res = Math.max(res, dfs(i - 1));
        for (int j = i - 2; j >= i - k - 1 && j >= 0; --j)
            if (b[k - (i - j - 1)] > a[j])
                
                res = Math.max(res, dfs(j));
        return memo[i] = ++res; 
    }
    private int lowerBound(int[] nums, int right, int target) {
        int left = -1;
        while (left + 1 < right) { 
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid; 
            else
                right = mid;
        }
        return right;
    }
}
