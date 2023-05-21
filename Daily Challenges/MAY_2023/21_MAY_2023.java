class Solution {
  private static final int[][] DIRECTIONS = new int[][] { {1,0}, {-1,0}, {0,1} };
  private static final int[][] ALLDIRECTIONS = new int[][] { {1,0}, {-1,0}, {0,1} , {0, -1} };
  public int shortestBridge(int[][] grid) {
    int[] start = findLeftMostLandCoord(grid);
    // assumes thereare two islands
    grid[start[0]][start[1]] = 2;
    Queue<int[]> seed = new LinkedList<>();
    seed.offer(start);
    Queue<int[]> que = expand(grid, seed, false);
    int count = 0;
    while(!que.isEmpty()) {
      count++;
      que = expand(grid, que, true);
    }
    return count;
    
  }
  
  
  private int[] findLeftMostLandCoord(int[][] grid) {
    for (int c=0;c<grid[0].length;c++) {
      for (int r=0;r<grid.length;r++) {
        if (grid[r][c] == 1) {
          return new int[] {r, c};
        }
      }
    }
    return new int[] {-1, -1};
  }
  

  
  private Queue<int[]> expand(int[][] grid, Queue<int[]> seed, boolean shouldDrainOn1) {
    Queue<int[]> border = new LinkedList<>();
    while(!seed.isEmpty()) {
      int[] current = seed.poll();
      for (int[] direction : Solution.ALLDIRECTIONS) {
        int newR = current[0] + direction[0];
        int newC = current[1] + direction[1];
        if (withinBounds(grid, newR, newC)) {
          if (grid[newR][newC] == 1) {
            if (shouldDrainOn1) {
              return new LinkedList<int[]>();
            }
            seed.offer(new int[] { newR, newC});
            grid[newR][newC] = 2;
          } else if (grid[newR][newC] == 0) {
            grid[newR][newC] = 3;
            border.offer(new int[] { newR, newC});
          }
        }
      }
    }
    return border;
  }
  
  private boolean withinBounds(int[][] grid, int r, int c) {
    return r >=0 && r < grid.length && c >= 0 && c < grid[r].length;
  }
}
