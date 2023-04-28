class Solution {
    int[] parent, rank;
    int groups, len;
    char[][] strsc;
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private boolean equal(int i1, int i2) {
        char[] s1 = strsc[i1], s2 = strsc[i2];
        int count = 0, idx1 = -1, idx2 = -1;
        for(int i = 0 ; i < len ; i++) {
            if(s1[i] != s2[i]) {
                if(idx1 == -1) idx1 = i;
                else if(idx2 == -1) idx2 = i;
                count += 1;
            }
            if(count > 2) return false;
        }
        if(idx1 == -1) return true;
        else if(idx2 == -1) return false;
        return s1[idx1] == s2[idx2] && s1[idx2] == s2[idx1];
    }
    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if(px == py || !equal(x, y)) return;
        if(rank[px] > rank[py]) parent[py] = px;
        else if(rank[px] < rank[py]) parent[px] = py;
        else {
            parent[py] = px;
            rank[px] += 1;
        }
        groups -= 1;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        groups = n;
        len = strs[0].length();
        strsc = new char[n][len];
        for(int i = 0 ; i < n ; i++) strsc[i] = strs[i].toCharArray();
        parent = new int[n]; rank = new int[n];
        for(int i = 1 ; i < n ; i++) parent[i] = i;
        for(int i = 0 ; i < n - 1 ; i++) {
            for(int j = i + 1 ; j < n ; j++)
                union(i, j);
        }
        return groups;
    }
}
