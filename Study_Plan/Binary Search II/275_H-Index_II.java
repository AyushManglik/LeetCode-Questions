// logarithmic time  --- >  Binary Search
class Solution {
    public int hIndex(int[] arr) {
        int start = 0, end = arr.length-1, ans = 0;
        while(start <= end) {
            int x = (start+end)>>1;
            if(arr[x] >= arr.length-x) {
                end = x-1;
                ans = arr.length-x;
            } else {
                start = x+1;
            }
        }
        return ans;
    }
}

//Brute force Approach --- > `O(n)`

/*
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
*/
