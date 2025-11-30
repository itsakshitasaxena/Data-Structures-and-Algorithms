class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0, min=nums.length, curr=0;
        for(int i:nums)
            sum=(sum+i)%p;
        int target=sum%p;
        if(target==0)  return 0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            curr=(curr+nums[i])%p;
            int rem=(curr-target+p)%p;
            if(map.containsKey(rem)){
                min=Math.min(min, i-map.get(rem));
            }
            map.put(curr,i);
        }
        return min==nums.length?-1:min;
    }
}