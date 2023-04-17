class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1, high=(position[position.length-1]-position[0])/(m-1);
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(mid, m, position)){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }

    public boolean isPossible(int force, int balls, int position[]){
        int b=1, lastBall=position[0];
        for(int i=1; i<position.length; i++){
            if(position[i]-lastBall>=force){
                b++;
                if(b==balls)
                    return true;
                lastBall=position[i];                
            }   
        }
        return false; 
    }
}
