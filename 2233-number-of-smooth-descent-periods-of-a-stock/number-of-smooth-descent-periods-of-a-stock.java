class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=1;
        int c=1;
        for(int i=1 ; i<prices.length ; i++){
            if(prices[i-1]-prices[i]==1){
                c++;
            }else{
                c=1;
            }
            ans += c;
        }
        return ans;
    }
}