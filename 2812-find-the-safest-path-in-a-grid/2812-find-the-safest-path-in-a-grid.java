import java.util.*;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();

        // Multi-source BFS initialization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // Max Heap: {safeness, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);

        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int safe = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;

            if (x == n - 1 && y == n - 1)
                return safe;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int newSafe = Math.min(safe, dist[nx][ny]);
                    pq.offer(new int[]{newSafe, nx, ny});
                }
            }
        }

        return 0;
    }
}