import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    static final int[][] NEIGHBOURS_OFFSETS = new int[][]{
        {0, +1},
        {+1, 0},
        {+1, +1},

        {0, -1},
        {-1, 0},
        {-1, -1},

        {+1, -1},
        {-1, +1},
        };

    private static boolean inBounds(int[] coords, int[][] matrix) {
        return inBounds(coords[0], coords[1], matrix);
    }

    private static boolean inBounds(int i, int j, int[][] matrix) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length;
    }

    static class MultiQueue<T> {

        final Queue<T>[] queues;

        public MultiQueue(final int size) {
            this.queues = new Queue[size];
            for (int i = 0; i < queues.length; i++) {
                this.queues[i] = new ConcurrentLinkedQueue<>();
            }
        }

        public void add(final int queue, final T item) {
            this.queues[queue].add(item);
        }

        public T poll(final int queueId) {
            return this.queues[queueId].poll();
        }

        public boolean isEmpty(final int queueId) {
            return this.queues[queueId].isEmpty();
        }

        public boolean allQueuesEmpty() {
            for (int i = 0; i < this.queues.length; i++) {
                if (!this.queues[i].isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        // Executor.
        if (grid[0][0] != 0) {
            return -1;
        }
        final int MULTIQ_SIZE = 1;
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        final MultiQueue<int[]> queue = new MultiQueue<>(MULTIQ_SIZE);
        final AtomicInteger minDistance = new AtomicInteger(-1);
        queue.add(0 % MULTIQ_SIZE, new int[]{0, 0, 0});
        final Thread[] threads = new Thread[MULTIQ_SIZE];
        final CountDownLatch countDownLatch = new CountDownLatch(MULTIQ_SIZE);
        for (int i = 0; i < threads.length; i++) {
            final int queueId = i;
            new Thread(() -> {
                while (!queue.allQueuesEmpty() && minDistance.get() < 0) {
                    if (queue.isEmpty(queueId)) {
                        continue;
                    }
                //    System.out.println(Thread.currentThread().getName() + " -> " + Arrays.toString(queue.queues));
                    final int[] node = queue.poll(queueId);
                    final int x = node[0];
                    final int y = node[1];
                    final int distance = node[2];
                    synchronized (visited) {
                        if (visited[x][y]) {
                            continue;
                        }
                        visited[x][y] = true;
                    }
                    if (x == grid.length - 1 && y == grid[0].length - 1) {
                        //return distance + 1;
                        minDistance.set(distance + 1);
                    } else {
                        for (final int[] offset : NEIGHBOURS_OFFSETS) {
                            final int nextX = x + offset[0];
                            final int nextY = y + offset[1];
                            synchronized (visited) {
                                if (inBounds(nextX, nextY, grid) && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                                    queue.add(
                                        nextX % MULTIQ_SIZE,
                                        new int[]{nextX, nextY, distance + 1});
                                }
                            }
                        }
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return minDistance.get();
    }
}
