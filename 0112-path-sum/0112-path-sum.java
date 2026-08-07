class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // If it is a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Check left or right subtree
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}