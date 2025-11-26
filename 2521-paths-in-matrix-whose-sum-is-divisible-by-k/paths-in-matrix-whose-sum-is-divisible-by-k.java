class Solution {
    int mod=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k];
        for(int[][] r:dp){
            for(int[] c:r)
                Arrays.fill(c,-1);
        }
        return find(0,0,grid[0][0]%k,grid,k,dp);

    }
    public int find(int i, int j, int rem,int[][] grid, int k,int[][][] dp){
        if(i>=grid.length||j>=grid[0].length) return 0;
        // sum+=grid[i][j];
        if(i==grid.length-1 && j==grid[0].length-1 && rem%k==0){
            return 1;
        }
        if(dp[i][j][rem]!=-1) return dp[i][j][rem];
        int right=0, down=0;
        if(j+1<grid[0].length)
            right=find(i,j+1,((rem+grid[i][j+1])%k),grid, k,dp);
        if(i+1<grid.length)
             down=find(i+1, j, ((rem+grid[i+1][j])%k), grid, k,dp);

        return dp[i][j][rem]=(right+down)%mod;
    }
}