class Solution {
    public int countHousePlacements(int n) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        long w=count(n,dp);
        return (int)((w*w)%1000000007);
    }
    public long count(int n,long[] dp){
        if(n<=0) return 1;
        if(dp[n]!=-1)  return dp[n];
        long a=count(n-1,dp);
        long b=count(n-2,dp);
        return dp[n]=(a+b)%1000000007;
    }
}