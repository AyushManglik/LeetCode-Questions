class Solution {
    /* Idea : When the actualSum and expectedSum are equal, that means all the left side bulbs are covered
    */
    public int numTimesAllBlue(int[] light){
       int i = 1;
       int expectedSum = 0;
       int actualSum = 0; 
       int ans = 0; 
       for(int num:light){
           actualSum += num;
           expectedSum += i;
           if(actualSum == expectedSum) ans++;
           i++;
       }
       return ans; 
    }
}
