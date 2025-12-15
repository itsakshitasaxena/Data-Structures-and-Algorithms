class Solution {
    public int numberOfWays(String corridor) {
        int mod=1000000007;
        char[] ch=corridor.toCharArray();
        int cnt=0, prev=0,t=1;
        for(char c:ch){
            if(c=='S'){
                cnt=prev;
                int temp=prev;
                prev=t;
                t=temp;
            }
            else{
                t=(t+cnt)%mod;
            }
        }
        return cnt;
    }
}