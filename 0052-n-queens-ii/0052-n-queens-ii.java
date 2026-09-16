class Solution {

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return solve(0, board, n);
    }

    private int solve(int row, boolean[][] board, int n) {

        // All queens successfully placed
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board, n)) {

                // Place queen
                board[row][col] = true;

                // Move to next row
                count += solve(row + 1, board, n);

                // Backtrack
                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isSafe(int row, int col, boolean[][] board, int n) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j]) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}