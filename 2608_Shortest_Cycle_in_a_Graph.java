class Solution {

    private int output = 1001;

    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<Integer>[] nexts = new ArrayList[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
        for (int[] edge : edges) for (int i = 0; i < 2; i++) nexts[edge[i]].add(edge[1 - i]);
        for (int i = 0; i < n; i++) if (ranks[i] == 0) findShortestCycle(nexts, i, -1, -1001, ranks);
        return output == 1001 ? -1 : output;
    }

    private void findShortestCycle(ArrayList<Integer>[] nexts, int c, int p, int r, int[] ranks) {
        ranks[c] = r;
        for (int n : nexts[c]) if (n != p)
            if (ranks[n] > r + 1) findShortestCycle(nexts, n, c, r + 1, ranks);
            else if (ranks[c] > ranks[n]) output = Math.min(output, ranks[c] - ranks[n] + 1);
    }

}
