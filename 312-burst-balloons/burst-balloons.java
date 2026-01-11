class Solution {
    public int maxCoins(int[] nums) {
        int[] neww=new int[nums.length+2];
        neww[0]=1;neww[nums.length+1]=1;
        for(int i=0;i<nums.length;i++)   neww[i+1]=nums[i];
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[] a: dp)  Arrays.fill(a, -1);

        return burst(neww, 0, nums.length+1, dp);
    }
    public int burst(int[] nums, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int ans=0;
        for(int k=i+1;k<j;k++){
            int left=burst(nums, i,k,dp);
            int right=burst(nums,k,j,dp);
            int itself=nums[i]*nums[j]*nums[k];
            ans=Math.max(itself+left+right,ans);
        }
        return dp[i][j]=ans;
    }
}