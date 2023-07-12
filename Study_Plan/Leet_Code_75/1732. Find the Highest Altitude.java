class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;    // max number initially the smallest integer

        int[] res = new int[gain.length + 1];   // resultant array to store the sum of all elements of the given array 'gain'

        res[0] = 0; //fisrt variable -> 0(always)

        //loop for finding the sum
        for(int i=0; i<gain.length;i++){
            res[i+1] = res[i] + gain[i];
        }

        // loop for finding the maximum element from the resultant array
        for (int j=0; j<res.length; j++){
            max = Math.max(res[j], max);
        }
        // As asked return the max element 
        return max;
    }
}
