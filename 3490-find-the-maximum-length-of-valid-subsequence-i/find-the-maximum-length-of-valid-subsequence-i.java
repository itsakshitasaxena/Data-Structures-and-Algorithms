class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length<=1)    return nums.length;
        int even=0,odd=0, cnt1=0, cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                cnt1++;
                even=Math.max(even, odd+1);
            }
            else{
                cnt2++;
                odd=Math.max(odd, even+1);
            }
        }
        return Math.max(Math.max(cnt1,cnt2),Math.max(even, odd));
    }
}