class Solution {
    int mod=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp=new int[zero+1][one+1][2];
// dp[i][j][0] → number of arrays using i zeros and j ones ending with 0
// dp[i][j][1] → number of arrays using i zeros and j ones ending with 1

    // Base case: only zeros (ending with 0):->Valid only if count <= limit
        for(int i=1;i<=Math.min(zero,limit);i++)  dp[i][0][0]=1;
        for(int i=1;i<=Math.min(one,limit);i++)
            dp[0][i][1]=1;  // Basecase: only ones (ending with 1)
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){ // Add a 0 at the end
                // It can come from: previous ended with 0 OR previous ended with 1
                dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1])%mod;
                if(i>limit)// If we exceed the limit of consecutive zeros remove those sequences where zeros exceed limit
                    dp[i][j][0]=(dp[i][j][0]+mod-dp[i-limit-1][j][1])%mod;
                    //Now,  Add a 1 at the end
                // It can come from: previous ended with 0 OR previous ended with 1
                dp[i][j][1]=(dp[i][j-1][0] + dp[i][j-1][1]) % mod;
                if(j>limit) // If we exceed limit of consecutive ones remove sequences where ones exceed limit
                    dp[i][j][1]=(dp[i][j][1]+mod-dp[i][j-limit-1][0])%mod;;
            }
        }
        return (dp[zero][one][0]+dp[zero][one][1])%mod;
    }
}