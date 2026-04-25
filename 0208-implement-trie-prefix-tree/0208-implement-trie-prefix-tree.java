class Trie {

    // Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Insert word
    public void insert(String word) {
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

    // Search full word
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    // Check prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Helper function
    private TrieNode findNode(String str) {
        TrieNode node = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}