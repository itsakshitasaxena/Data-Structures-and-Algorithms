class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][4];
        for(int[] a:dp)  Arrays.fill(a,-1);
        return cooldown(prices, 0, 0,dp);
    }
    public int cooldown(int[] p, int i, int op, int[][] dp){
        if(i>=p.length)  return 0;
        if(op==4)  return 0;
        if(dp[i][op]!=-1)  return dp[i][op];

        int ans=0;
        if(op%2==0){
            int sell=cooldown(p,i+1,op+1,dp)-p[i];
            int not_sell=cooldown(p,i+1,op,dp);
            ans=Math.max(sell, not_sell);
        }
        else{
            int sell=cooldown(p,i+1,op+1,dp)+p[i]; //cooldown after sell
            int not_sell=cooldown(p,i+1,op,dp);
            ans=Math.max(sell,not_sell);
        }
        return dp[i][op]=ans;
    }
}