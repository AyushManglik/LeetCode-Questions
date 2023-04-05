// beats 97%
class Solution {
    public boolean judgeSquareSum(int c) {
        long i =0 ;
        long j = (long)Math.sqrt(c);
        while(i<=j){
            long mid = i*i+j*j;
            if(mid == c){
                return true;
            }
            else if(mid > c){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}

// bruteforce beats 6%

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}
