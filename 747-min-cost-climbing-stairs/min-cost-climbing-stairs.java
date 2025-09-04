class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp, -1);
        int first=min_stairs(cost, 0, dp);
        int second=min_stairs(cost, 1, dp);
        return Math.min(first, second);
    }
    public static int min_stairs(int[] cost, int i, int[] dp){
        if(i>=cost.length)  return 0;

        // int[] dp=new int[cost.length];

        if(dp[i]!=-1)   return dp[i];
        
        int one=cost[i]+min_stairs(cost, i+1, dp);
        int two=cost[i]+min_stairs(cost,i+2, dp);

        return dp[i]=Math.min(one, two);
    }
}