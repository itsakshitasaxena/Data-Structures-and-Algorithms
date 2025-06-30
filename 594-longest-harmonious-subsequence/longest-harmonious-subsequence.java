class Solution {
    public int findLHS(int[] nums) {
    //     Arrays.sort(nums);
        int maxlen=0,i=0,j=0;
    //     while(i<nums.length){
    //         while(nums[i]-nums[j]>1){
    //             j++;
    //         }
    //         if(nums[i]-nums[j]==1){
    //             maxlen=Math.max(maxlen,i-j+1);
    //         }
    //         i++;
    //     }
    HashMap<Integer, Integer> map=new HashMap<>();
    for(i=0;i<nums.length;i++){
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
    }
    for(int a:map.keySet()){
        if(map.containsKey(a+1))
            maxlen=Math.max(maxlen, map.get(a)+map.get(a+1));
        }
        return maxlen;
    }
}
