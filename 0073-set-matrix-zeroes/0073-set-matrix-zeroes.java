class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;

        // Step 1: Mark rows and columns
        for(int i = 0; i < m; i++) {

            if(matrix[i][0] == 0)
                col0 = 0;

            for(int j = 1; j < n; j++) {

                if(matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Fill matrix using markers
        for(int i = 1; i < m; i++) {

            for(int j = 1; j < n; j++) {

                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: First row
        if(matrix[0][0] == 0) {

            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: First column
        if(col0 == 0) {

            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}