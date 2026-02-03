class Solution {
    int mod=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {

        // dp[i][j][0] --> valid arrays having i 0's, j 1's, ending with 0
        // dp[i][j][1] --> valid arrays having i 0's, j 1's, ending with 1
        int[][][] dp=new int[zero+1][one+1][2];
        for(int i=0;i<=Math.min(zero, limit);i++)
            dp[i][0][0]=1;  // Base cases: only zeros (allowed only till limit)
        for(int j=0;j<=Math.min(one,limit);j++)
            dp[0][j][1]=1;  // Base cases: only ones (allowed only till limit)
        
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                // Ending with 0: append 0 to previous arrays
                dp[i][j][0]=(dp[i-1][j][0] + dp[i-1][j][1]) % mod;
                if(i > limit) //Remove invalid arr having (limit + 1) consecutive 0s
                    dp[i][j][0]=(dp[i][j][0] - dp[i-limit-1][j][1] + mod) % mod;

                // Ending with 1: append 1 to previous arrays
                dp[i][j][1]=(dp[i][j-1][0] + dp[i][j-1][1]) % mod;
                if(j > limit) //Remove invalid arr having (limit + 1) consecutive 1s
                    dp[i][j][1]=(dp[i][j][1] - dp[i][j-limit-1][0] + mod) % mod;

            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod; //arr ending with 0 or 1
    }
}