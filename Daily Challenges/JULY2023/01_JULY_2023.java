class Solution{
    public int distributeCookies(int[] cookies, int k){
        int[] ppl = new int[k];
        return helper(cookies, ppl, 0, k);
    }
    
    public int helper(int[] cookies, int[] ppl, int idx, int cookieless){
        if(cookies.length-idx<cookieless) return Integer.MAX_VALUE;
        if(idx == cookies.length){
            int ans = 0;
            for(int num: ppl){
                ans = Math.max(num, ans);
            }
            return ans;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < ppl.length; i++){
            cookieless-=ppl[i]==0?1:0;
            ppl[i] += cookies[idx];
            res = Math.min(res, helper(cookies, ppl, idx+1,cookieless));
            ppl[i] -= cookies[idx];
            cookieless+=ppl[i]==0?1:0;
            if(ppl[i]==0)break;
        }
        return res;
    }
}   
