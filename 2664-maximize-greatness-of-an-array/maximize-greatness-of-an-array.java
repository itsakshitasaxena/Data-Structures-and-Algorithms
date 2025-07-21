class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int greatness=0, start=nums.length-2, end=nums.length-1;
        while(start>=0 && end>=0){
            if(nums[start]<nums[end]){
                greatness++;
                end--;
            }
            start--;
        }
        // for(int i:nums){
        //     if(i>nums[greatness])
        //         greatness++;
        // }
        return greatness;
    }
}