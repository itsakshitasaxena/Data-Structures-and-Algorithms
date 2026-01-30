class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        Deque<Integer> dq=new ArrayDeque<>();
        dq.add(0);
        for(int i=1;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst() < i-k)   
                dq.pollFirst(); //remove indices that are too far to reach curr idx
            int curr=dq.peekFirst(); //dp front contains max value
            dp[i]=nums[i]+dp[curr];
            while(!dq.isEmpty() && dp[dq.peekLast()]<dp[i])
                dq.pollLast(); //remove who is less than the curr idx
            dq.add(i);
        }
        return dp[nums.length-1];
    }
}