class WordDictionary {

    // Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    // Constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word to Trie
    public void addWord(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    // Search with support for '.'
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    // DFS helper function
    private boolean searchHelper(String word, int i, TrieNode node) {
        if (node == null) return false;

        // If reached end of word
        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        // Case 1: normal character
        if (ch != '.') {
            return searchHelper(word, i + 1, node.children[ch - 'a']);
        }

        // Case 2: wildcard '.'
        for (int j = 0; j < 26; j++) {
            if (node.children[j] != null) {
                if (searchHelper(word, i + 1, node.children[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}