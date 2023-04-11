// logarithmic time  --- >  Binary Search
/*class Solution{
    public int hIndex(int[] citations){
        int ans = 0, start = 0, end = citations.length;
        while (start <= end){
            int mid = start + (end-start)/2;
            if ((citations.length-mid) <= citations[mid]){
                ans = Math.max(citations.length-mid,ans);
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return ans;
    }
}
*/

//Brute force Approach --- > `O(n)`

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for (int i=0; i < citations.length; i++){
            if(n-i <= citations[i]){
                return n-i;
            }
        }
        return 0;
    }
}
