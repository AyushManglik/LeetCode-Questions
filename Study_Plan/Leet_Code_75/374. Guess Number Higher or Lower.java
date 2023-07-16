public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (guess(mid) <= 0)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
