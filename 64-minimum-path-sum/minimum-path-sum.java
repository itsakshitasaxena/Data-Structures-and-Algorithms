class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp)     Arrays.fill(a, -1);
        return minsum(grid, 0, 0, dp);
    }
    public static int minsum(int[][] ar, int r, int c, int[][] dp){
        if(r==ar.length-1 && c==ar[0].length-1)
            return ar[r][c]; 
        if(r>=ar.length ||  c>=ar[0].length)
            return Integer.MAX_VALUE;
        if(dp[r][c]!=-1)    return dp[r][c];
        
        int right=minsum(ar, r, c+1, dp);
        int down=minsum(ar, r+1, c, dp);
        return dp[r][c]=Math.min(right, down)+ar[r][c];

    }
}