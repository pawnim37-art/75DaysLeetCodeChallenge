import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        // 1. Build Trie
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        // 2. Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        // Store complete word
        curr.word = word;
    }

    private void dfs(char[][] board, int row, int col,
                     TrieNode node, List<String> result) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        // Already visited
        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        // Current character is not a Trie path
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Avoid duplicate result
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore 4 directions
        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        // Backtrack
        board[row][col] = ch;
    }
}