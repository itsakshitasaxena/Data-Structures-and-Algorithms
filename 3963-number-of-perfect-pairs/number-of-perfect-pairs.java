class Solution {
    public long perfectPairs(int[] nums) {
        long n=nums.length, ans=0;
        for(int i=0;i<n;i++)  nums[i]=Math.abs(nums[i]);
        Arrays.sort(nums);
        int left=0, right=0;
        while(right<n){
            while(nums[right]>2L*nums[left]){
                left++;
            }
            ans+=(right-left);
            right++;
        }
        return ans;
    }
}