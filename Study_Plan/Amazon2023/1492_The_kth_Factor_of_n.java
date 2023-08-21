/*
// My Solution
class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if (n%i == 0){
                ans.add(i);
            }
        }
        if (k > ans.size()){
            return -1;
        }
        return ans.get(k-1);
    }
}
*/

class Solution {
    public int kthFactor(int n, int k) {
        int count = 1;
        for(int i=1; i<=n; i++){
            if(n%i == 0 ){
                if(count == k){
                    return i;
                }
                count++;
            }
        }
        return -1;
    }
}
