class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        // Shortest Path => bfs!
        int m = grid.length;
        int n = grid[0].length();
        char[][] board = new char[m][n];
        int[] start = new int[2];
        int key = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = grid[i].charAt(j);
                if (board[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i][j] - 'a' >= 0 && board[i][j] - 'a' < 26) {
                    key++;
                }
            }
        }
        int max = (1 << key) - 1;
        // 若是這鑰匙的這個狀態已經看過了，沒必要再回去試一次，這是我沒想到的
        // 這比較難一點，還是需要visited，否則會無窮回圈
        boolean[][][] visited = new boolean[m][n][max];
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] top = queue.poll();
                char c = board[top[0]][top[1]];
                int k = top[2];
                if (c - 'a' >= 0 && c - 'a' < 26) {
                    k = k | (1 << (c - 'a'));
                }
                if (k == max) {
                    return ans;
                }
                for (int[] d : directions) {
                    int x = top[0] + d[0];
                    int y = top[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] == '#' || visited[x][y][k]) {
                        continue;
                    }
                    if (board[x][y] - 'A' >= 0 && board[x][y] - 'A' < 26) {
                        int index = board[x][y] - 'A';
                        if ((k & (1 << index)) == 0) {
                            continue;
                        }
                    }
                    queue.offer(new int[]{x, y, k});
                    visited[x][y][k] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
