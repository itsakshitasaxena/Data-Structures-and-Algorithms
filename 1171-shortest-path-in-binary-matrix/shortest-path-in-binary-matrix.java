class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int path=1,n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;

        boolean[][] vis=new boolean[n][n];
        int[] dr={1,-1,0,0,-1,+1,-1,+1};
        int[] dc={0,0,1,-1,-1,+1,+1,-1};
        Queue<int[]> qu=new LinkedList<>();
        qu.add(new int[]{0,0});
        vis[0][0]=true;
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int k=0;k<size;k++){
                int[] curr=qu.poll();
                int r=curr[0],c=curr[1];
                if(r==n-1&&c==n-1)  return path;
                for(int i=0;i<8;i++){
                    int nr=r+dr[i],nc=c+dc[i];
                    if(nr>=0&&nc>=0&&nr<n&&nc<n&&grid[nr][nc]==0&&!vis[nr][nc]){
                        vis[nr][nc]=true;
                        qu.add(new int[]{nr,nc});
                    }
                }
            }
            path++;
        }
        
        return -1;
    }
}
    // public void dfs(int[][] grid, int i, int j, boolean[][] vis){
    //     if(i>0||j>0||i<grid.length||j<grid[0].length) return;
    //     if(grid[i][j]==1) return;
    //     vis[i][j]=true;
    //     dfs(grid,i+1,j,vis);
    //     dfs(grid,i-1,j,vis);
    //     dfs(grid,i,j-1,vis);
    //     dfs(grid,i,j+1,vis);
    //     dfs(grid,i-1,j-1,vis);
    //     dfs(grid,i+1,j+1,vis);
    //     dfs(grid,i-1,j+1,vis);
    //     dfs(grid,i+1,j-1,vis);
    // }