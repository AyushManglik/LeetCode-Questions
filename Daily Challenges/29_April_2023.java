class Solution {
    int[] parent;
    int[] rank;
    int[] weight;
    public boolean[] distanceLimitedPathsExist(int n, int[][] E, int[][] Q) {
        parent = new int[n];
        rank = new int[n];
        weight = new int[n];
        for (int i = 0; i < n ; i++) parent[i] = i;

        Arrays.sort(E, (a,b) -> a[2] - b[2]);
        for (var e : E) union(e[0], e[1], e[2]);

        boolean[] res = new boolean[Q.length];
        for (int i = 0 ; i < Q.length; i++)
            res[i] = query(Q[i][0], Q[i][1], Q[i][2]);

        return res;
    }
    
    public boolean query(int p, int q, int limit) {
        return find(p, limit) == find(q, limit);
    }

    private int find (int x, int limit) {
        while (x != parent[x]) {
            if (weight[x] >= limit) {
                break;
            }
            x = parent[x];
        }
        return x;
    }

    private void union (int x, int y, int limit) {
        int x_ref = find (x, Integer.MAX_VALUE);
        int y_ref = find (y, Integer.MAX_VALUE);
        if (x_ref == y_ref) {
            return;
        }
        if (rank[x_ref] < rank[y_ref]) {
            parent[x_ref] = y_ref;
            weight [x_ref] = limit;;
        } else {
            parent[y_ref] = x_ref;
            weight[y_ref] = limit;
            if (rank[x_ref] == rank[y_ref]) {
                rank[x_ref]++;
            }
        }
    }
}
