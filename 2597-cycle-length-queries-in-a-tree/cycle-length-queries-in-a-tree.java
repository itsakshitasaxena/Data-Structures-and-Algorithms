class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans=new int[queries.length];
        for(int i=0;i<ans.length;i++)
            ans[i]=cycle_len(queries[i][0], queries[i][1]);
        return ans;
    }
    public int cycle_len(int a, int b){
        int dist=0;
        while(a!=b){
            if(a>b)  a/=2;
            else b/=2;
            dist++;
        }
        return dist+1;
    }
}