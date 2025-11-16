class Solution {
    public int numSub(String s) {
        int cnt=0,ans=0; 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                cnt++;
                ans+=cnt;
                ans%=1000000007;
            }
            else cnt=0;
        }
        return ans%1000000007;
    }
}