class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
       return combo(nums,0,target,dp);   
    }
    public int combo(int[] nums, int sum,int target, int[] dp){
        if(sum==target)  return 1;
        if(sum>target){
            return 0;
        }
        int cnt=0;
        if(dp[sum]!=-1)  return dp[sum];
        for(int i=0;i<nums.length;i++){
            cnt+=combo(nums,sum+nums[i],target,dp);
        }
        return dp[sum]=cnt;
    }
}