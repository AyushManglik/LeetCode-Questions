// Aopproach-1

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

// Approach-2
class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = Arrays.stream(piles).max().getAsInt();

    while (l < r) {
      final int m = (l + r) / 2;
     if (eatHours(piles, m) <= h)
        r = m;
      else
        l = m + 1;
    }

    return l;
  }

// Hours to eat all piles with speed m
  private int eatHours(int[] piles, int m) {
    return Arrays.stream(piles).reduce(0, (subtotal, pile) -> subtotal + (pile - 1) / m + 1); // Math.ceil(pile / m)
  }
}
