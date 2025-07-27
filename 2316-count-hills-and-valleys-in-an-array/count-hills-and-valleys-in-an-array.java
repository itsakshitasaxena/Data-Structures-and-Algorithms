class Solution {
    public int countHillValley(int[] nums) {
        int cnt=0;
        for(int i=1 ; i<nums.length-1 ; i++){
            int j=i-1;
            if(nums[i]==nums[j]) continue;
            int k=j+1;
            while(k<nums.length && nums[k]==nums[i]){
                k++;
            }
            if(j<0 || k>=nums.length) continue;
            if(nums[i]>nums[j] && nums[i]>nums[k]) cnt++;
            else if(nums[i]<nums[j] && nums[i]<nums[k]) cnt++;
        }
        return cnt;
    }
}