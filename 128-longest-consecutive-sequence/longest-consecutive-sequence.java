class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int cnt=0,key=nums[i];
                while(set.contains(key)){
                    set.remove(key);
                    key++;cnt++;
                    
                }
                ans=Math.max(cnt,ans);

            }
        }
        return ans;
    }
}