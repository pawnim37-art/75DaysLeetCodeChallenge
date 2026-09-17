class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // Word completely matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return false;
        }

        // Character does not match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found =
                dfs(board, word, i + 1, j, index + 1) || // down
                dfs(board, word, i - 1, j, index + 1) || // up
                dfs(board, word, i, j + 1, index + 1) || // right
                dfs(board, word, i, j - 1, index + 1);   // left

        // Backtrack: restore original character
        board[i][j] = temp;

        return found;
    }
}