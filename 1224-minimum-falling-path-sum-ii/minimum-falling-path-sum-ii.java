class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp)     Arrays.fill(a, -101);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++)
            ans=Math.min(ans, minsum(grid,0,i,dp));
        
        return ans;
    }

    public static int minsum(int[][] ar, int r, int c, int[][] dp){
         
        // if(c<0 || c>=ar[0].length)
        //     return Integer.MAX_VALUE;
        if(r==ar.length-1)
            return ar[r][c];

        if(dp[r][c]!=-101)    return dp[r][c];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<dp[0].length;i++){
            if(c!=i)
                ans=Math.min(ans,minsum(ar, r+1, i, dp)); 
        }
        // int diag_left=minsum(ar, r+1, c-1, dp);
        // int diag_right=minsum(ar, r+1, c+1, dp);
        // int diag_down=minsum(ar, r+1, c, dp);
        
        return dp[r][c]=ans+ar[r][c];
    }
}