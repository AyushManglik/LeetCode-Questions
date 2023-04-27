class Solution {
    public int addDigits(int num) {
            // base Condiiton
        if(num==0)  return 0;
        // if num>0 then we only need to check whether the number is divisible by 9 or not.
        if(num%9==0) return 9;  // Number is divisible by 9 then return 9

        return num%9;  // otherwise return the remainder num%9
    }
}
