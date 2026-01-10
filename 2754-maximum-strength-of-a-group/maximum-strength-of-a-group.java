class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length==1) return nums[0];
        long pro=1,min=Integer.MIN_VALUE,zero=0;
        Arrays.sort(nums);
        boolean z=false;
        for(int i:nums){
            if(i>0) {
                pro*=i;
                z=true;
            }
        }
        for(int i=0;i+1<nums.length;i++){
            if(nums[i]<0 && nums[i+1]<0){ //multiply -ves in pairs
                pro*=(nums[i]*nums[i+1]);
                i++;
                z=true;
            }
        }
        return z?pro:0;
        
    }
}