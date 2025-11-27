class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans=Long.MIN_VALUE,sum=0;
        long[] pref=new long[k];
        Arrays.fill(pref,Long.MAX_VALUE/2);
        pref[k-1]=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int r=i%k;
            ans=Math.max(ans,sum-pref[r]);
            pref[r]=Math.min(pref[r],sum);
        }
        
            
        return ans;
    }
}