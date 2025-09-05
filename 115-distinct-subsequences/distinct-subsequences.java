class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return dis_TD(s, t, 0, 0, dp);
    
    }
    public static int dis_TD(String s, String t, int i, int j, int[][] dp){
        if(j==t.length())   return 1; // t string- finish

        if(i==s.length())   return 0; //s string end

        if(dp[i][j]!=-1)    return dp[i][j];   //return already have

        int inc=0, exc=0;
        if(s.charAt(i)==t.charAt(j))    inc= dis_TD(s, t, i+1, j+1, dp); // both index+1

        exc=dis_TD(s, t, i+1, j, dp); // only s index+1

        return dp[i][j]=inc+exc; // store count of both
    }
}