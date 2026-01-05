class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int[] fr=new int[nums.length];
        Arrays.fill(fr,1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        fr[i]=fr[j];
                    }
                    else if(dp[j]+1==dp[i]){
                        fr[i]+=fr[j];
                    }
                }
            }
        }
        int max=0,cnt=0;
        for(int i:dp){
            if(i>max) max=i;
        }
        for(int i=0;i<nums.length;i++){
            if(dp[i]==max) cnt+=fr[i];
        }
        return cnt;
             
    }
}