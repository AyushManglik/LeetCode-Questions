class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        int or = a | b;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            if ((c & bit) == bit) {
                if ((or & bit) == 0) {
                    flips++;
                }
            } else if ((or & bit) == bit) {
                if ((a & bit) == bit) {
                    flips++;
                }
                if ((b & bit) == bit) {
                    flips++;
                }
            }
        }
        return flips;
    }
}
