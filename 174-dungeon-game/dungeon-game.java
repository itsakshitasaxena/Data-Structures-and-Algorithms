class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp=new int[dungeon.length][dungeon[0].length];
        for(int[] ar:dp)  Arrays.fill(ar,-1);
        return dgame(0,0,dp,dungeon);
    }

    public int dgame(int i, int j, int[][] dp, int[][] ar){
        if(i>=ar.length||j>=ar[0].length)  return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)   return dp[i][j];
        if(i==ar.length-1 && j==ar[0].length-1)
            return Math.max(1, 1-ar[i][j]);
        int right=dgame(i,j+1,dp,ar);
        int down=dgame(i+1,j,dp,ar);
        int need=Math.min(right, down)-ar[i][j];

        return dp[i][j]=Math.max(1, need);
    }
}