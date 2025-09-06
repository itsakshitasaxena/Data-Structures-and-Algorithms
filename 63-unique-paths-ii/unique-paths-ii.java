class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] aa:dp)       Arrays.fill(aa, -1);
        return unique(obstacleGrid, 0, 0, dp);
    }
    public static int unique(int[][] ar, int i, int j, int[][] dp){
            
        if(i>=ar.length || j>=ar[0].length || ar[i][j]==1)    return 0;
        if(i==ar.length-1 && j==ar[0].length-1)    return 1;

        if(dp[i][j]!=-1)     return dp[i][j];

        int right=unique(ar, i, j+1, dp);
        int down=unique(ar, i+1, j, dp);

        return dp[i][j]=right+down;
    }
}