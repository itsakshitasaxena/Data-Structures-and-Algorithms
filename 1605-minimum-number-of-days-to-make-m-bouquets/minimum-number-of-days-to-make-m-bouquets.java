class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        //Tc-O(Nlog(Max(Bloomday)))
        if((long)m*k>bloomDay.length)  return -1;
        int lo=Integer.MAX_VALUE,hi=0;
        for(int i=0;i<bloomDay.length;i++){
            hi=Math.max(hi,bloomDay[i]);
            lo=Math.min(lo,bloomDay[i]);
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(ispossible(bloomDay,mid,m,k)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
    public boolean ispossible(int[] bloom, int day, int m, int k){
        int cnt=0,bouquet=0;
        for(int i=0;i<bloom.length;i++){
            if(bloom[i]<=day) cnt++;
            else{
                bouquet+=(cnt/k);
                cnt=0;
            }
        }
        bouquet+=(cnt/k);
        return bouquet>=m;
    }
}