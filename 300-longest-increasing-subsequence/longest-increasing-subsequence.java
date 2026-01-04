class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }
    public int lis(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for(int i:dp){
            if(i>max) max=i;
        }
        return max;
    }
}