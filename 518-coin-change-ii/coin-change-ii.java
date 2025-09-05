class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length+1];
        for(int[] a:dp)    Arrays.fill(a, -1);
        // return coin_TD(coins, amount, 0, dp);
        return coin_changeBU(coins, amount);
    }
    public static int coin_TD(int[] coin, int amt, int i, int[][] dp){
        if(amt==0)           return 1;
        if(i>=coin.length)     return 0;

        if(dp[amt][i]!=-1)     return dp[amt][i];

        int inc=0, exc=0;
        if(coin[i]<=amt)
            inc=coin_TD(coin, amt-coin[i], i, dp); //infinite availability of coins
        exc=coin_TD(coin, amt, i+1, dp);

        return dp[amt][i]=inc+exc;
    }


     public static int coin_changeBU(int[] coin, int amt){
        int[][] dp=new int[coin.length+1][amt+1];
        for(int i=0;i<dp.length;i++){ // first row- all 0
            dp[i][0]=1;
        }
        // here i is coins index
        for(int i=1;i<dp.length;i++){ 
            for(int am=1;am<dp[0].length;am++){ //amount
                int inc=0, exc=0;
                if(am>=coin[i-1]){
                    // removed last coin for that dp
                    inc=dp[i][am-coin[i-1]];
                }
                exc=dp[i-1][am];
                dp[i][am]=inc+exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}