class Solution {
    public int climbStairs(int n) {
       int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return count(0,n,dp);
    }
    public int count(int i, int n, int[] dp){
        if(i>n)  return 0;
        if(i==n) return 1;

        if(dp[i]!=-1)   return dp[i];

        int one=count(i+1, n,dp);
        int two=count(i+2, n, dp);

        return dp[i]=one+two;
    }
}