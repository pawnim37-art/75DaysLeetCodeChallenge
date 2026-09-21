class Solution {

    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        // Check whether the current square is uniform
        boolean same = true;
        int first = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != first) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
        }

        // If all values are same, create a leaf node
        if (same) {
            return new Node(first == 1, true);
        }

        // Divide into 4 quadrants
        int half = size / 2;

        Node topLeft = build(grid, row, col, half);
        Node topRight = build(grid, row, col + half, half);
        Node bottomLeft = build(grid, row + half, col, half);
        Node bottomRight = build(grid, row + half, col + half, half);

        // Current node is not a leaf
        return new Node(
            true,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}