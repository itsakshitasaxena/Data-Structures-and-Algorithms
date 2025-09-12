class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)  return nums[0];
        int[] dp1=new int[nums.length];
        Arrays.fill(dp1,-1);
        int[] dp2=new int[nums.length];
        Arrays.fill(dp2,-1);
        return Math.max(robber2(nums,0, nums.length-2,dp1), robber2(nums,1, nums.length-1,dp2));
    }
    public static int robber2(int[] ar, int i, int j, int[] dp){
        if(i>j)
            return 0;
        
        if(dp[j]!=-1){
            return dp[j];
        }

        int rob=ar[j] +robber2(ar,i,j-2,dp);
        int dont_rob=robber2(ar,i,j-1,dp);
        return dp[j]=Math.max(rob, dont_rob);
    }
}