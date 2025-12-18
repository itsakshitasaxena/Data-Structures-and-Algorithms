class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        //int[] k=new int[2];
        while(i<nums.length)
        {
            int j=i+1;
            while(j<nums.length)
            {
                if(nums[i]+nums[j]==target)
                    return  new int[]{i,j};
                j++;
            }
            i++;
        }
        return new int[]{};
}
}