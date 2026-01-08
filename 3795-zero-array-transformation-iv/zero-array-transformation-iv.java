class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            int[][] dp=new int[nums[i]+1][queries.length];
            for(int[] a:dp)  Arrays.fill(a,-1);
            ans=Math.max(ans,transform(queries,i,nums[i],0,dp));
        }
        return ans>queries.length?-1:ans;
    }
    
    //target--> remaining value to reduce to 0, k--> current query index
    public int transform(int[][] qu, int i, int target,int k, int[][] dp){
        if(target==0)  return k; 
        if(k>=qu.length||target<0)  return qu.length+1; 
        if(dp[target][k]!=-1)  return dp[target][k];
        int res=transform(qu,i,target,k+1,dp); //skip current query val
        if(qu[k][0]<=i && i<=qu[k][1])
            res=Math.min(res,transform(qu,i,target-qu[k][2],k+1,dp));
        return dp[target][k]=res;
    }
}