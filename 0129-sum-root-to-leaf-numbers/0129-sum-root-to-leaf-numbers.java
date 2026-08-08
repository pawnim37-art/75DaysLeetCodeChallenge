class Solution {

    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode root, int current) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Build the number
        current = current * 10 + root.val;

        // If leaf node
        if (root.left == null && root.right == null) {
            return current;
        }

        // Recursively calculate left and right
        return solve(root.left, current)
             + solve(root.right, current);
    }
}