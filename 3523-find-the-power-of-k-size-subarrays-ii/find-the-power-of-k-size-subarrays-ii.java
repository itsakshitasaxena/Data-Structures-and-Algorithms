class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1)   return nums;
        int[] ans=new int[nums.length-k+1];
        Arrays.fill(ans,-1);
        int cnt=1,i=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]+1) cnt=1; //reset if not consecutive
            else{
                cnt++; //encounter a consecutive element, increase cnt
                if(cnt>=k)   ans[i-k+1]=nums[i]; //good window ele
            }
            i++;
        }
        return ans;
    }
}