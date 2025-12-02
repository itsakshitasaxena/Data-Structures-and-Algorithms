class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dist=new int[n][m];
        int[][] vis=new int[n][m];
        Queue<Pair> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    qu.add(new Pair(i,j,0));
                    vis[i][j]=1;
                    dist[i][j]=0; //dist from itself=0
                }
            }
        }
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        while(!qu.isEmpty()){
            Pair rp=qu.poll();
            int r=rp.row;
            int c=rp.col;
            int d=rp.dist;
            dist[r][c]=d;
            for(int i=0;i<4;i++){
                int nr=r+drow[i], nc=c+dcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0){
                    qu.add(new Pair(nr,nc,d+1));
                    vis[nr][nc]=1;
                }
            }
        }
        return dist;
        
    }
    class Pair{
        int row,col,dist;
        Pair(int row,int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
}