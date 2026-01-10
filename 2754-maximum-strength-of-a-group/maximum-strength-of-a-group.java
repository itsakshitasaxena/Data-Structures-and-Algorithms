class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length==1) return nums[0];
        long pro=1,min=Integer.MIN_VALUE,zero=0,ans=1;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==0){
                zero++;
                continue;
            }
            if(nums[i]<0) min = Math.max(min,nums[i]);
            ans *= nums[i];
        }
        if(zero==nums.length || (zero!=0 && zero==nums.length-1 && min!=Integer.MIN_VALUE)) return 0;
        if(ans<0) return ans/min;
        return ans;
        
    }
}

// Arrays.sort(nums);
//         boolean z=false;
//         for(int i:nums){
//             if(i>0) {
//                 pro*=i;
//                 z=true;
//             }
//         }
//         for(int i=0;i+1<nums.length;i++){
//             if(nums[i]<0 && nums[i+1]<0){ //multiply -ves in pairs
//                 pro*=(nums[i]*nums[i+1]);
//                 i++;
//                 z=true;
//             }
//         }
//         return z?pro:0; 