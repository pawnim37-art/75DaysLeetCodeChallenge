class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        int left = Math.max(0, findMax(node.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, findMax(node.right));

        // Maximum path passing through current node
        int currentPath = left + node.val + right;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return maximum contribution to parent
        return node.val + Math.max(left, right);
    }
}