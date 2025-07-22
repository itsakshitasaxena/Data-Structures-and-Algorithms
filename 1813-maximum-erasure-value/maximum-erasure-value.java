class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max_score=0,i=0,j=0, sum=0;
        HashSet<Integer> set=new HashSet<>();
        while(i<nums.length){
            while(set.contains(nums[i])){
                set.remove(nums[j]);
                sum-=nums[j];
                j++;
            }
            sum+=nums[i];
            set.add(nums[i]);
            max_score=Math.max(max_score, sum);
            i++;
        }
        return max_score;
    }
}