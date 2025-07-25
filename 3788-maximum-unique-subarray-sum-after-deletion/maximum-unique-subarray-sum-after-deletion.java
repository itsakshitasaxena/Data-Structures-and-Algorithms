class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int min=Integer.MIN_VALUE,sum=0;
        for(int i:set){
            if(i>0)  sum+=i;
            else min=Math.max(min,i);
        }
        if(sum==0&&!set.contains(0))  sum=min;
        return sum;
    }
}