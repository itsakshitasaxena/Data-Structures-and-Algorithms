class Solution {
    public int numEnclaves(int[][] grid) {
        int cnt=0, n=grid.length,m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int j=0;j<m;j++){
            if(!vis[0][j]&&grid[0][j]==1)
                dfs(0,j,vis,grid);
            if(!vis[n-1][j]&&grid[n-1][j]==1)
                dfs(n-1,j,vis,grid);

        }
        for(int i=0;i<n;i++){
            if(!vis[i][0]&&grid[i][0]==1)
                dfs(i,0,vis,grid);
            if(!vis[i][m-1]&&grid[i][m-1]==1)
                dfs(i,m-1,vis,grid);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]&&grid[i][j]==1)
                    cnt++;
            }
        }
        return cnt;
    }
    public static void dfs(int r, int c, boolean[][] vis, int[][] board){
        vis[r][c]=true;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int n=board.length, m=board[0].length;
        for(int i=0;i<4;i++){
            int nr=r+drow[i], nc=c+dcol[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&!vis[nr][nc]&&board[nr][nc]==1){
                dfs(nr,nc,vis,board);
            }
        }
    }
}