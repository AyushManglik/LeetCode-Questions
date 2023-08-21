class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int hottest = 0;
        
        for(int i = temperatures.length - 1; i >= 0 ; i --){
            int cur = temperatures[i];
            if(cur >= hottest){
                hottest = cur;
                continue;
            }
            int day = 1;
            while(cur >= temperatures[i + day])
                day += res[i + day];
            res[i] = day;
        }
        return res;
    }
}
