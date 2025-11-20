class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l=0, r=nums.length-1,max=0;
        while(l<r){
            int pair=nums[l]+nums[r];
            max=Math.max(pair,max);
            l++;r--;
        }
        return max;
    }
}