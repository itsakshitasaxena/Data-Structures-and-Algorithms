class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a=-1;
        int lo=0, hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                a=mid;
                hi=mid-1;
            }
            else if(nums[mid]<target)
                lo=mid+1;
            else
                hi=mid-1;
        }
        int b=lastindex(nums,target);
        return new int[]{a,b};
    }
    public static int lastindex(int[] nums, int target){
        int lo=0, hi=nums.length-1,b=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                b=mid;
                lo=mid+1;
            }
            else if(target<nums[mid])
                hi=mid-1;
            else
                lo=mid+1;
        }
        return b;
    }
}