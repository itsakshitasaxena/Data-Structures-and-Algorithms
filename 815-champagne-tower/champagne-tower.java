class Solution {
    private double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[query_row+1][query_glass+1];
        for(double[] a:dp){
            Arrays.fill(a,-1);
        }
        return Math.min(1.0,find(query_row,query_glass,poured));
    }
    private double find(int i, int j, int k){
        
        if(i<0|| j<0||j>i)return 0;
        if(i==0  && j==0)return k;
        if(dp[i][j]!=-1)return dp[i][j];
        // find(i-1,j-1,k) amount of champ in left parent 
        // -1 esliye kyuki parent 1 champ hold karta hai 
        // /2 to divide overflow champ to left and right child
        double left = Math.max(0,find(i-1,j-1,k)-1)/2;
        double right = Math.max(0,find(i-1,j,k)-1)/2;
        return dp[i][j]=left+right;
    }
}