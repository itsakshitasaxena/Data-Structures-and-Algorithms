class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] nm=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];
            for(int j=r1;j<=r2;j++){
                for(int k=c1;k<=c2;k++){
                    nm[j][k]+=1;
                }
            }
        }
         return nm;
    }
}