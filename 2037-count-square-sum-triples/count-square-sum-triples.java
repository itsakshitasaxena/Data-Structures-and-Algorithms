class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for(int a=1;a<n;a++){
            for(int b=a+1;b<n;b++){
                int sumsq=a*a+b*b;
                int c=(int)Math.sqrt(sumsq);
                if(c*c==sumsq&&c<=n)  cnt+=2;
            }
        }
        return cnt;
    }
}