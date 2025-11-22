class Solution {
    public int minimumOperations(int[] nums) {
        int cnt=0;
        for(int i:nums) 
            cnt+=Math.min(i%3, (3-(i%3)));
        return cnt;
    }
}