class Solution {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                int live = 0;

                for(int[] d : dir){

                    int nr = i + d[0];
                    int nc = j + d[1];

                    if(nr>=0 && nr<m &&
                       nc>=0 && nc<n &&
                       Math.abs(board[nr][nc])==1){

                        live++;
                    }
                }

                if(board[i][j]==1){

                    if(live<2 || live>3)
                        board[i][j]=-1;
                }
                else{

                    if(live==3)
                        board[i][j]=2;
                }
            }
        }

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(board[i][j]==-1)
                    board[i][j]=0;

                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
}