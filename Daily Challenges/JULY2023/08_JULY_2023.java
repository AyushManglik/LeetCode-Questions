class Solution {
    public long putMarbles(int[] weights, int k) {

        int[] score = new int[weights.length - 1];

        for (int i = 0; i < weights.length - 1; i++) {
            score[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(score);

        long minScores = 0;
        long maxScores = 0;

        for (int i = 0; i < k - 1; i++) {
            minScores += score[i];
            maxScores += score[score.length - 1 - i];
        }
        return maxScores - minScores;
    }
}
