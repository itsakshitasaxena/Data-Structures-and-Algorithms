class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        Boolean[] dp = new Boolean[n];
        return helper(0,nums,dp);
    }
    public boolean helper(int idx, int[] nums, Boolean[] dp){
        int n=nums.length;
        if(idx >= n) return true;
        if(dp[idx] != null)    return dp[idx];
        
        boolean res = false;
        if(idx < n-1 && nums[idx] == nums[idx+1])
            res |= helper(idx+2,nums,dp);
        
        if(idx < n-2 && nums[idx] == nums[idx+1] && nums[idx] == nums[idx+2])
            res |= helper(idx+3, nums, dp);
        
        if(idx < n-2 && nums[idx] == nums[idx+1]-1 && nums[idx] == nums[idx+2]-2)
            res |= helper(idx+3, nums,dp);
        
        return dp[idx] = res;
    }
}