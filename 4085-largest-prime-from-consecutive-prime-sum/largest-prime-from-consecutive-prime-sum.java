class Solution {
    public int largestPrime(int n) {
        if(n<2)    return 0;
        //prime sieve
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int i=2;i*i<n;i++){
            if(prime[i]){
                for(int j=2;i*j<=n;j++)  prime[i*j]=false;
            }
        }
        int add=0,ans=0;
        for(int i=2;i<=n;i++){
            if(prime[i])       add+=i;
            if(add>n)  break;
            if(prime[add])    ans=add;
        }
        return ans;
    }
}