class Solution {
    public int minDistance(String word1, String word2) {
       int[][] dp=new int[word1.length()][word2.length()];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return min_ops(word1, word2, 0, 0, dp);
    }
    public static int min_ops(String s, String t, int i, int j, int[][] dp){
        if(i==s.length())  return t.length()-j;

        if(j==t.length())  return s.length()-i;

        if(dp[i][j]!=-1)   return dp[i][j];

        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=min_ops(s, t, i+1, j+1, dp);
        }
        else{
            int D=min_ops(s, t, i+1, j, dp);
            int R=min_ops(s, t, i+1, j+1, dp);
            int I=min_ops(s, t, i, j+1, dp);
            // int r=min_ops(s, t, i+1, j+1);
            ans=1+ Math.min(D, Math.min(R,I));
        }
        return dp[i][j]=ans;
    }
}