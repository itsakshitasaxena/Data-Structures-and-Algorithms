class Solution {
    int mod=1000000007;
    public int monkeyMove(int n) {
        //total ways--> 2^n - 2 safe cases(when all move in cw / acw)
        long cnt=collision(2,n);
        return ((int)cnt-2+mod)%mod; //as -2 % mod  gives -2 so doing +mod before 
    }
    public long collision(long x, long nn){
        long ans=1;
        while(nn>0){
            if(nn%2==1){ //if odd 
                ans=(ans*x)%mod;
                nn-=1;
            }
            else{ //if even
                x=(x*x)%mod;
                nn/=2;
            }
        }
        return ans;
    }
}