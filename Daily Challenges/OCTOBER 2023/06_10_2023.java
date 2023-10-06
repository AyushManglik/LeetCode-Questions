/*
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }
        
        if (n % 3 == 1) {
            return (int) Math.pow(3, (n / 3 - 1)) * 4;
        }
        
        return (int) Math.pow(3, n / 3) * 2;
    }
}
*/
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        
        return ans * n;
    }
}
