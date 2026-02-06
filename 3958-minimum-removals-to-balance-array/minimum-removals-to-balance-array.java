class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt=0,i=0,j=0;
        while(i<nums.length){
            while(j<nums.length && nums[j] <= (long)nums[i] * k )
                j++;
            cnt=Math.max(cnt,j-i);
            i++;
        }
        return nums.length-cnt;


    }
}