class Solution {
    int mod=1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k==1)  return kadanes(arr);
        long sum=0;
        for(int i:arr)  sum+=i;
        int[] newwar=new int[arr.length*2];
        for(int i=0;i<newwar.length;i++)
            newwar[i]=arr[i%arr.length];
        
        if(sum<=0) return kadanes(newwar);
        return (kadanes(newwar)+(int)(((k-2)*sum)%mod))%mod;//prefix + middle full arrays + suffix
        
    }
    public int kadanes(int[] newwar){
        long sum=0,maxsum=0;
        for(int i=0;i<newwar.length;i++){
            sum+=newwar[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0) sum=0;
        }
        return (int)maxsum%mod;
    }
}