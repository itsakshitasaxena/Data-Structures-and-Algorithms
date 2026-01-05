class Solution {
    HashSet set;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        dp=new Boolean[s.length()];
        return breakk(0,s);
    }
    public boolean breakk(int i, String s){
        if(i==s.length())  return true;
        if(dp[i]!=null)  return dp[i];
        for(int j=i+1;j<=s.length();j++){ 
            if(set.contains(s.substring(i,j))&&breakk(j,s))
                return dp[i]=true;
        }
        return dp[i]=false;
    }
}