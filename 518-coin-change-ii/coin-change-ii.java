class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length+1];
        for(int[] a:dp)    Arrays.fill(a, -1);
        return coin_TD(coins, amount, 0, dp);
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
}