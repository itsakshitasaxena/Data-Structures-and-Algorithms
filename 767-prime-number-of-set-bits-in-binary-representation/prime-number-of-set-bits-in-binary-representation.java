class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        while(left<=right){
            int c=0,copy=left;
            while(copy>0){
                if((copy&1)==1)  c++;
                copy>>=1;
            }
            if(prime(c))  cnt++;
            left++;
        }
        return cnt;

    }
    public boolean prime(int n){
        if(n<=1)  return false;
        if(n==2 ) return true;
        if(n%2==0)  return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0)  return false;
        }
        return true;
    }
}