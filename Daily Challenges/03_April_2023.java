class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] count = new int[limit+1];
        for(int p : people) count[p]++;

        int index = 0;
        for(int val=1; val<=limit; val++){
            while(count[val]-- > 0)
                people[index++] = val;
        }
        
        int boatCount = 0, left = 0, right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            boatCount++;
        }
        return boatCount;
    }
}
