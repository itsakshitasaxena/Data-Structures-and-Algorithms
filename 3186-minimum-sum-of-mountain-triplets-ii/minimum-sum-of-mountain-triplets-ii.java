class Solution {
    public int minimumSum(int[] nums) {
        int ans=Integer.MAX_VALUE,n=nums.length;
        int[] pref=new int[n];
        int[] suff=new int[n];
        pref[0]=nums[0];suff[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pref[i]=Math.min(pref[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.min(suff[i+1],nums[i]);
        }
        for(int j=1;j<n-1;j++){
            int sum=0;
            if(pref[j-1]<nums[j] && nums[j]>suff[j+1]){
                sum+=(pref[j-1]+nums[j]+suff[j+1]);
                ans=Math.min(ans, sum);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}