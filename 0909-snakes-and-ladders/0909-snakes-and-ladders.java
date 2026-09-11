import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Convert square number to (row, col)
        int[] cells = new int[n * n + 1];
        int num = 1;

        for (int row = n - 1; row >= 0; row--) {
            if ((n - row) % 2 == 1) {
                // Left to right
                for (int col = 0; col < n; col++) {
                    cells[num++] = board[row][col];
                }
            } else {
                // Right to left
                for (int col = n - 1; col >= 0; col--) {
                    cells[num++] = board[row][col];
                }
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) {
                    return moves;
                }

                // Dice: 1 to 6
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;

                    if (next > n * n) {
                        break;
                    }

                    // Snake or ladder
                    if (cells[next] != -1) {
                        next = cells[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}