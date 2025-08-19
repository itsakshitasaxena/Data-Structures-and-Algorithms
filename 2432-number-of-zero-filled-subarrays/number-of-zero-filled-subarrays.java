class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt=0, z=0;
        int end=0;
        while(end<nums.length){

            if(nums[end]==0){
                z++;
                cnt+=z;
            }
            else{
                z=0;
            }
            end++;
        }
        return cnt;
    }
}