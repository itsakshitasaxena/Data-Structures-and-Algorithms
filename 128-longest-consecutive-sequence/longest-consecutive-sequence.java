class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int ans=0;
    //"Start only when it’s the beginning. Grow the sequence. Track the max."
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int key=nums[i],cnt=0;
                while(set.contains(key)){
                    set.remove(key);
                    key++; cnt++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}