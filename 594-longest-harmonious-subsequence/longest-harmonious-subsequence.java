class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxlen=0,i=0,j=0;
        while(i<nums.length){
            while(nums[i]-nums[j]>1){
                j++;
            }
            if(nums[i]-nums[j]==1){
                maxlen=Math.max(maxlen,i-j+1);
            }
            i++;
        }
        return maxlen;
    }
}
