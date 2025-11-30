class Solution {
    int mod=1000000007;
    public int countPalindromes(String s) {
        long ans=0;
        Integer[][][][] dp=new Integer[s.length()][10][10][6];//(n,0-9,0-9,5+1)
        for(int a=0;a<10;a++){
            for(int b=0;b<10;b++){
                ans=(ans+find(0,s,a,b,0,dp))%mod;
            }
        }
        return (int)ans;
    }
    public int find(int idx, String st, int a, int b,int len, Integer[][][][]dp){
        if(len==5) return 1; //find palindrome of len 5
        if(idx==st.length()) return 0; //no palindrome
        if(dp[idx][a][b][len]!=null)  return dp[idx][a][b][len];
        int digit=st.charAt(idx)-'0'; //extracting string dig
        long ways=0; //counting using take and not take
        int noTake=find(idx+1,st,a,b,len,dp),take=0;
        //remember bricks-(a,b,x,b,a)
        if(len==0&&digit==a)
            take=find(idx+1,st,a,b,len+1,dp);
        else if(len==1&&digit==b)
            take=find(idx+1,st,a,b,len+1,dp);
        else if(len==2) //middle dig can be anything
            take=find(idx+1,st,a,b,len+1,dp);
        else if(len==3&&digit==b)
            take=find(idx+1,st,a,b,len+1,dp);
        else if(len==4&&digit==a)
            take=find(idx+1,st,a,b,len+1,dp);
        ways+=take%mod+noTake%mod; // to excape from overflow
        dp[idx][a][b][len]=(int)ways;
        return (int)ways;
    }
}