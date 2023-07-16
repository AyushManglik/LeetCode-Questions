import java.util.*;
class Solution {
  public int minEatingSpeed(int[] piles, int H) {
    if (piles == null || piles.length == 0) 
        return 0;

    int max = 0;
    for (int p: piles) 
        max = Math.max(max, p);
    int st = 1, ed = max;
    while (st < ed) {
      int mid = (st + ed) / 2;
      if (timeTaken(piles, H, mid)) 
        ed = mid;
      else st = mid + 1;
    }
    return ed;
  }
  private boolean timeTaken(int[] piles, int H, int K) {
    int time = 0;
    for (int i: piles) {
      time += i / K;
      if (i % K != 0) 
        time++;
    }
    return time <= H;
  }
}
