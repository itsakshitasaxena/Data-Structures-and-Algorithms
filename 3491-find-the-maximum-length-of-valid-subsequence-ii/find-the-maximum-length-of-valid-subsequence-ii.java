class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp=new int[k][nums.length];
        for(int[] a:dp) Arrays.fill(a,1);
        int ans=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int mod=(nums[i]+nums[j])%k;
                dp[mod][i]=Math.max(dp[mod][i],dp[mod][j]+1);
                ans=Math.max(ans,dp[mod][i]);
            }
        }
        return ans;
    }
}