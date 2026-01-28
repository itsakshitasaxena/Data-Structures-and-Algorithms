class Solution {
    //static String[] key={"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    int mod=1_000_000_007;
    public int countTexts(String pressedKeys) {
        int n=pressedKeys.length();
        long[] dp=new long[n+1];
        dp[0]=1; //as empty string has 1 valid decoding
        for(int i=1;i<=n;i++){
            char ch=pressedKeys.charAt(i-1);
            int maxpress=(ch=='7'|ch=='9') ? 4 : 3;
            long cnt=0;
            for(int j=1;j<=maxpress && i-j>=0;j++){
                if(pressedKeys.charAt(i-j)!=ch) break; //Digits must be the same to form one letter
                cnt=(cnt+dp[i-j])%mod;
            }
            dp[i]=cnt;
        }
        return (int) dp[n];

    }
}