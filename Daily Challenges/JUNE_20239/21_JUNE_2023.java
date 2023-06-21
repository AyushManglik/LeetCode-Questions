class Solution {
    int [] nums;
    int [] cost;
    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        int val =  bs(0, 1_000_000);
        return c(val);
    }

    int bs(int st, int e )
    {
          
         int mid = (st + e + 1)/2;
         if(st == e)
         {
             return st;
         }
         long cmid = c(mid);
         long pmid = c(mid -1);
      

         if(cmid >= pmid)
         {
             return bs(st, mid-1);
         }

        return bs(mid, e);

    }

    long c(int val)
    {
        long ans = 0; 
        for(int i = 0; i< nums.length; i++)
        {
           ans += (long)Math.abs(nums[i]-val) * cost[i];
        }
        return ans;
    }
}
