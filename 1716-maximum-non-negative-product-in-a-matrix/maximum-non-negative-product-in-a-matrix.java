class Solution {
    public int maxProductPath(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        // maxdp[i][j] = maximum product till (i,j)
        // mindp[i][j] = minimum product till (i,j)
        // (needed because negative * negative = positive)
        long[][] mindp=new long[m][n];
        long[][] maxdp=new long[m][n];
        mindp[0][0]=grid[0][0]; maxdp[0][0]=grid[0][0];
        for(int j = 1; j < n; j++){  // first row (only coming from left)
            maxdp[0][j] = maxdp[0][j-1] * grid[0][j];
            mindp[0][j] = maxdp[0][j]; // same since only one path
        }
        for(int i = 1; i < m; i++){ // first col (only coming from top)
            maxdp[i][0] = maxdp[i-1][0] * grid[i][0];
            mindp[i][0] = maxdp[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long val=grid[i][j];
                 // 4 possibilities:
                // from top max, from top min, from left max, from left min
                long a = val * maxdp[i-1][j];
                long b = val * mindp[i-1][j];
                long c = val * maxdp[i][j-1];
                long d = val * mindp[i][j-1];
                // take best and worst
                maxdp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                mindp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        return maxdp[m-1][n-1] < 0 ?-1 : (int) (maxdp[m-1][n-1] % 1_000_000_007);
    }
}