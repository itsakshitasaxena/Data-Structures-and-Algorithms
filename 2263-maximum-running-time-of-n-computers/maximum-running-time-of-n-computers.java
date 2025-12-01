class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum =0;
        for(int i:batteries)    sum+=i;
        long lo=0, hi=sum/n, ans=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(ispossible(batteries,n,mid)){
                ans=mid;
                lo=mid+1;
            }
            else  
                hi=mid-1;
       }
       return ans;
    }
    public boolean ispossible(int[] ar , int n, long mid){
        long total=0;
        for(int i:ar){
            total+=Math.min(i,mid);
        }
        return total>=(long)n*mid;
    }
}