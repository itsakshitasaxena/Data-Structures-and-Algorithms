class Solution {
    public int findLHS(int[] nums) {
    int maxlen=0;
    HashMap<Integer, Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++)
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
    
    for(int a:map.keySet()){
        if(map.containsKey(a+1))
            maxlen=Math.max(maxlen, map.get(a)+map.get(a+1));
        }
        return maxlen;
    }
}
