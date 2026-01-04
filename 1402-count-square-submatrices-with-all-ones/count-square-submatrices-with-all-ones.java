class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length,cnt=0;
        int[][] dp=new int[m][n];
        for(int[] a:dp)  Arrays.fill(a,-1);
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cnt+=submatrix_cnt(matrix,dp,i,j);
            }
        }
        return cnt; 
    }
    public int submatrix_cnt(int[][] ar, int[][] dp, int i, int j){
        if(i>=ar.length||j>=ar[0].length||i<0||j<0||ar[i][j]==0) return 0;
        if(dp[i][j]!=-1)  return dp[i][j];
        
        int t=submatrix_cnt(ar,dp,i-1,j); 
        int b=submatrix_cnt(ar,dp,i,j-1); 
        int d=submatrix_cnt(ar,dp,i-1,j-1);
        return dp[i][j]=Math.min(t,Math.min(b,d))+1;
    }
}