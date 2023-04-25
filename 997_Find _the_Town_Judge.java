class Solution {
  public int findJudge(int n, int[][] trust) {
    int[] freq = new int[n+1];
    for (int[] person: trust) {
      freq[person[0]]--;
      freq[person[1]]++;
    }
    for (int i = 1; i <= n; ++i) {
      if (freq[i] == n - 1) return i;
    }
    return -1;
  }
}
