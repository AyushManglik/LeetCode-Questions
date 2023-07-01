class Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int M = row;
        int N = col;
        int[][] matrix = new int[M][N];
        for (int[] r : matrix) Arrays.fill(r, -1);
        DSU dsu = new DSU(M * N + 2);
        int top = M * N, bottom = M * N + 1;
        for (int j = 0; j < N; j++) {
            dsu.union(top, 0 * N + j); //first row all connect to top
            dsu.union(bottom, (M - 1) * N + j); //last row all connect to bottom
        }
        int index = cells.length - 1;
        while (dsu.find(top) != dsu.find(bottom) && index >= 0) {
            int[] cell = cells[index--];
            int i = cell[0] - 1, j = cell[1] - 1;
            matrix[i][j] = 0;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && y >= 0 && x < M && y < N && matrix[x][y] == 0)
                    dsu.union(i * N + j, x * N + y);
            }
        }
        return index + 1;
    }
}

class DSU {
    int[] parent;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);  
    }
}
