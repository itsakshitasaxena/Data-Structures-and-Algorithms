class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return maxsum(arr,0,k,dp);
    }
    public int maxsum(int[] arr,int ind, int k, int[] dp){
        if(ind>=arr.length)  return 0;
        if(dp[ind]!=-1)  return dp[ind];
        int max=0, len=0,maxele=0;
        for(int i=ind;i<arr.length&&len<k;i++){
            maxele=Math.max(maxele,arr[i]);
            len++;
           int sum=maxele*len+maxsum(arr,i+1,k,dp);
            max=Math.max(max,sum);
        }
        return dp[ind]=max;
    }
}