class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] subseq=new int[k];
        int[] copy=nums.clone();
        Arrays.sort(copy);
        HashMap<Integer, Integer> map=new HashMap<>();
        int cnt=0,j=0;
        for(int i=nums.length-1;i>=0;i--){
            map.put(copy[i],map.getOrDefault(copy[i],0)+1);
            cnt++;
            if(cnt==k)    break;
        }
        for(int i=0;i<nums.length&&j<k;i++){
            if(map.getOrDefault(nums[i],0)>0){
                subseq[j++]=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
            }
        }
        return subseq;
    }
}