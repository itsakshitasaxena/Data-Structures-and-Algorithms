class Solution {
    public double myPow(double x, int n) {
        long nn=n;
        double ans=1;
        if(nn<0) nn=-1*nn; //if power is -ve make it +ve then at last divide it by 1
        while(nn>0){
            if(nn%2==1){ //if odd 
                ans=ans*x;
                nn-=1;
            }
            else{ //if even
                x*=x;
                nn/=2;
            }
        }
        if(n<0)  return 1/ans;
        return ans;
    }
}