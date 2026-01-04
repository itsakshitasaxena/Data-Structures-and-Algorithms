class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] a:dp) Arrays.fill(a,-1);
        int res=lcs(word1,word2,0,0,dp);
        int lensum=word1.length()+word2.length();
        return lensum-2*res;
    }
    public int lcs(String w1, String w2, int i, int j, int[][] dp){
        if(i>=w1.length()||j>=w2.length())  return 0;
        if(dp[i][j]!=-1)  return dp[i][j];
        int ans=0;
        if(w1.charAt(i)==w2.charAt(j)){
            ans=1+lcs(w1,w2,i+1,j+1,dp);
        }
        else{
            int f=lcs(w1,w2,i+1,j,dp);
            int s=lcs(w1,w2,i,j+1,dp);
            ans=Math.max(f,s);
        }
        return dp[i][j]=ans;
    }
}