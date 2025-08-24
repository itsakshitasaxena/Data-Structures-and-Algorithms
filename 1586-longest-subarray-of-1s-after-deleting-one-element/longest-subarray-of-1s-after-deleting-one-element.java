class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen=0,start=0,end=0,k=0;
        while(end<nums.length){
            if(nums[end]==0){ //atmost 1 zzero
                if(k==1){
                    while(nums[start++]!=0); //shrink

                }
                k=1; 
            }
            
            maxlen=Math.max(maxlen, end-start); 
            end++; //grow
        }
        return maxlen;
    }
}