class Solution {
    public int candy(int[] ratings) {
        int[] cendies = new int[ratings.length];
        
        for(int i=0; i<cendies.length; ++i){
            cendies[i]=1;
        }

        for(int i=1; i<cendies.length; ++i){
            if(ratings[i]>ratings[i-1]){
                cendies[i]=cendies[i-1]+1;
            }
        }

        for(int i=cendies.length-2; i>=0; --i){
            if(ratings[i]>ratings[i+1] && cendies[i]<cendies[i+1]+1){
                cendies[i]=cendies[i+1]+1;
            }
        }

        int sum=0;
        for(int i=0; i<cendies.length; ++i){
            sum+=cendies[i];
        }
        return sum;
    }
}
