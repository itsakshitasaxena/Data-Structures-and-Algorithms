class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0,dp);
    }
    public int decode(String st, int i,int[] dp){
        if(i==st.length())  return 1;
        if(st.charAt(i)=='0')  return 0;
        if(dp[i]!=-1)  return dp[i];
        int ways=0;
        ways+=decode(st,i+1,dp);
        if(i+1<st.length()){
            int val=Integer.parseInt(st.substring(i,i+2));
            if(val<=26)  
                ways+=decode(st,i+2,dp);

        }
        return dp[i]=ways;
    }
}