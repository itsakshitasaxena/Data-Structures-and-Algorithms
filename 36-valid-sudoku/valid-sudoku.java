class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.' && !isitsafe(board ,i,j))
                    return false;
            }
        }
        return true;
    }

    public static boolean isitsafe(char[][] grid, int row, int col){
        char ch=grid[row][col];
        //for column
        for(int i=0;i<grid.length;i++){
            if(i==row) continue;
            if(grid[i][col]==ch)
                return false;
        }
        //for row
        for(int i=0;i<grid.length;i++){
            if(i==col) continue;
            if(grid[row][i]==ch)
                return false;
        }
        //in 3*3 sub-box
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(i==row && j==col) continue;
                if(grid[i][j]==ch)
                    return false;
            }
        }
        return true;
    }
}