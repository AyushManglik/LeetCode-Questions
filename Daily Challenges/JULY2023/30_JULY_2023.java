class Solution {
    private int[][] memo;
    private char[] array;
    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        array = squash(s);
        int N = array.length;
        memo = new int[N][];

        for (int i = 0; i < N; i++) {
            memo[i] = new int[N];
            memo[i][i] = 1;
            if (i != N - 1) {
                int next = i + 1;
                memo[i][next] = array[i] == array[next] ? 1 : 2;
            }
        }
        return strangePrinter(0, array.length - 1);
    }
    public int strangePrinter(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] == 0) {

            int nextIdx = i + 1;
            int letter = array[i];

            int answer = 1 + strangePrinter(nextIdx, j);

            for (int k = nextIdx; k <= j; k++) {
                if (array[k] == letter) {

                    int betterAnswer = strangePrinter(i, k - 1) + strangePrinter(k + 1, j);
                    answer = Math.min(answer, betterAnswer);
                }
            }
            memo[i][j] = answer;
        }
        return memo[i][j];
    }
    char[] squash(String s) {
        char[] chars = s.toCharArray();
        int last = 0;
        int fullLength = chars.length;
        for (int i = 1; i < fullLength; i++) {
            if (chars[i] != chars[last]) {
                chars[++last] = chars[i];
            }
        }
        return Arrays.copyOf(chars, last + 1);
    }
}
