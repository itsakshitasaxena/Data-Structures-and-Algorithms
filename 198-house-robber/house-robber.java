class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return rob_TD(nums, 0, dp);
    }
    public static int rob_TD(int[] ar, int i, int[] dp){
        if(i>=ar.length)    return 0;
        if(dp[i]!=-1)       return dp[i];

        int rob=ar[i]+rob_TD(ar, i+2, dp);
        int dont_rob=rob_TD(ar, i+1, dp);
        return dp[i]=Math.max(rob, dont_rob);
    }
}