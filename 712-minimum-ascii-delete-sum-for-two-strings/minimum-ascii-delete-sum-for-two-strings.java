class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()][s2.length()];
        for(int[] a:dp)  Arrays.fill(a,-1);
        return minsum(s1,s2,0,0,dp);
    }
    public int minsum(String s1, String s2, int i, int j,int[][] dp){
        if(i>=s1.length()){ // when s1 ends, delete all chars of s2
            int sum=0;
            for(int k=j;k<s2.length();k++)
                sum+=s2.charAt(k);
            return sum;
        }
        if(j>=s2.length()){ // when s2 ends, delete all chars of s1
            int sum=0;
            for(int k=i;k<s1.length();k++)
                sum+=s1.charAt(k);
            return sum;
        }
        if(dp[i][j]!=-1)  return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) 
            return dp[i][j]=minsum(s1,s2,i+1,j+1,dp);
        int take1=s1.charAt(i)+minsum(s1,s2,i+1,j,dp);
        int take2=s2.charAt(j)+minsum(s1,s2,i,j+1,dp);
        return dp[i][j]=Math.min(take1,take2);

    }
}