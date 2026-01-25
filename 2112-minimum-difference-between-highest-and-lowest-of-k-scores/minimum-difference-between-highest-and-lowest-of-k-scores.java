class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE, n=nums.length;
        for(int i=0;i+k-1<n;i++)
            min=Math.min(min, nums[i+k-1]-nums[i]);
        return min;
    }
}