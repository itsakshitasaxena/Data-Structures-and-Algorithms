class Solution {
    public long maxSumTrionic(int[] nums) {
        long[][] dp=new long[nums.length][4];
        for(long[] j:dp) Arrays.fill(j, Long.MIN_VALUE);
        return maxsum(nums,0,0,dp);
    }
    public long maxsum(int[] nums, int i, int trend, long[][] dp){
        // dp[i][trend] = max sum starting from index i
        // trend:
        // 0 -> not started
        // 1 -> increasing
        // 2 -> decreasing
        // 3 -> final increasing

        if(i>=nums.length)   return trend==3?0:Long.MIN_VALUE/2; //all checks are done for trionic array 

        if(dp[i][trend]!=Long.MIN_VALUE)  return dp[i][trend];
        long skip=Long.MIN_VALUE/2, take=Long.MIN_VALUE/2;

        if(trend==0){ // We can skip ele ONLY before starting the subarray
           skip=  maxsum(nums,i+1,trend,dp);
        }
        if(trend==3) // Once in final inc phase, we may end anytime
             take=nums[i];

        if(i<nums.length-1) {
        int curr=nums[i], next=nums[i+1];
            if(curr<next && trend==0){ //start inc
                take=curr+maxsum(nums,i+1,1,dp);
            }
            if(trend==1) {// Increasing phase
                if(curr<next){ // continue increasing
                    take=curr+maxsum(nums,i+1,1,dp);
                }
                else if(curr>next){ // switch to decreasing
                    take=curr+maxsum(nums,i+1,2,dp);
                }
            }
            if(trend==2){ // Decreasing phase
                if(curr>next){ // continue decreasing
                    take=curr + maxsum(nums,i+1,2,dp);
                }
                else if(curr<next) // switch to final increasing
                    take=curr+maxsum(nums,i+1,3,dp);
            }
            if(trend==3 && curr<next){ // Final increasing phase
                take=Math.max(take,curr + maxsum(nums,i+1,3,dp));
            }
        }
        return dp[i][trend]=Math.max(skip,take);


    }
}