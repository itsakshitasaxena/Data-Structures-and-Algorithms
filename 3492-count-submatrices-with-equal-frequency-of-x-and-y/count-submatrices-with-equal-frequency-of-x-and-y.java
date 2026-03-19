class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int ans=0, n=grid.length, m=grid[0].length;
        int[][] cntX=new int[n][m];
        int[][] cntY=new int[n][m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                cntX[i][j]=(grid[i][j]=='X') ? 1 : 0;
                cntY[i][j]=(grid[i][j]=='Y') ? 1: 0;
                if(i>0){
                    cntX[i][j]+=cntX[i-1][j];
                    cntY[i][j]+=cntY[i-1][j];
                }
                if(j>0){
                    cntX[i][j]+=cntX[i][j-1];
                    cntY[i][j]+=cntY[i][j-1];
                }
                if(i>0 && j>0){
                    cntX[i][j]-=cntX[i-1][j-1];
                    cntY[i][j]-=cntY[i-1][j-1];
                }
                if(cntX[i][j]==cntY[i][j] && cntX[i][j]>0) ans++;

            }
        }
        return ans;
    }
}