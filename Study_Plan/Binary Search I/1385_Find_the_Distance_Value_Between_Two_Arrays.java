class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean countIncrease = true;
            for (int j : arr2) {
                int dist = Math.abs(i - j);
                if (dist <= d) {
                    countIncrease = false;
                    break;
                }
            }
            if (countIncrease) count++;
        }
        return count;
    }
}
