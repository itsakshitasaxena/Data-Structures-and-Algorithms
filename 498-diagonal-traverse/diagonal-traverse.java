class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r=0, c=0, i=0, m=mat.length, n=mat[0].length;
        int[] ans=new int[m*n];
        boolean isUp=true;
        while(r<m && c<n){
            if(isUp){ //upwards direction
                while(r>0 && c<n-1){
                    ans[i++]=mat[r][c];
                    r--; c++;
                }
                ans[i++]=mat[r][c];
                if(c==n-1)  r++;
                else    c++;
            }
            else{ //downwards direction
                while(c>0 && r<m-1){
                    ans[i++]=mat[r][c];
                    c--; r++;
                }
                ans[i++]=mat[r][c];
                if(r==m-1)  c++;
                else    r++;
            }
            isUp=!isUp;
        }
        return ans;
    }
}