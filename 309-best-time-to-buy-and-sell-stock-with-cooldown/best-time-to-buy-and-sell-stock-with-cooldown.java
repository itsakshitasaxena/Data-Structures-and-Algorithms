class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp)  Arrays.fill(a,-1);
        return cooldown(prices, 0, 1,dp);
    }
    public int cooldown(int[] p, int i, int buy, int[][] dp){
        if(i>=p.length)  return 0;
        if(dp[i][buy]!=-1)  return dp[i][buy];

        int ans=0;
        if(buy==1){
            int sell=cooldown(p,i+1,0,dp)-p[i];
            int not_sell=cooldown(p,i+1,1,dp);
            ans=Math.max(sell, not_sell);
        }
        else{
            int sell=cooldown(p,i+2,1,dp)+p[i]; //cooldown after sell
            int not_sell=cooldown(p,i+1,0,dp);
            ans=Math.max(sell,not_sell);
        }
        return dp[i][buy]=ans;
    }
}