class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length,area=Integer.MIN_VALUE;
        int[][] dp=new int[m][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                area=Math.max(area,maxsquare(matrix, dp, i,j));
            }
        }
        return area*area;
    }
    public int maxsquare(char[][] mat, int[][] dp, int i, int j){
        if(i>=mat.length||j>=mat[0].length||i<0||j<0||mat[i][j]=='0')  return 0;
        
        if(dp[i][j]!=-1)  return dp[i][j];
        int ans=0;
        if(mat[i][j]=='1'){
            int t=maxsquare(mat,dp,i-1,j-1);
            int d=maxsquare(mat,dp,i-1,j);
            int  b=maxsquare(mat,dp,i,j-1);
            ans=Math.min(t,Math.min(d,b))+1;
        }
        return dp[i][j]=ans;
    }
}