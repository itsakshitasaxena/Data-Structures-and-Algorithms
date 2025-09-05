class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)  return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, -2);
        int ans=coin_TD(coins, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
     public static int coin_TD(int[] coin, int amt, int[] dp){
        if(amt==0)           return 0;
        if(amt<0)     return Integer.MAX_VALUE;

        if(dp[amt]!=-2)     return dp[amt];

        int min=Integer.MAX_VALUE;
        for(int i:coin){
            int aa=coin_TD(coin, amt-i, dp);
            if(aa!=Integer.MAX_VALUE)
                min=Math.min(aa+1, min);
        }
        dp[amt]=min;

        return dp[amt];
    }
}