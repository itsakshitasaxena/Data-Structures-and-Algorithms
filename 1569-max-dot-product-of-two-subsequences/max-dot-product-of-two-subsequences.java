class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        for(int[] aa:dp)  Arrays.fill(aa,Integer.MIN_VALUE);
        return maxdot(nums1,nums2,0,0,dp);
    }
    public int maxdot(int[] n1, int[] n2, int i, int j, int[][] dp){
        if(i>=n1.length||j>=n2.length)  return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE)   return dp[i][j];

        int take=n1[i]*n2[j]+Math.max(0,maxdot(n1,n2,i+1,j+1,dp)); 
        //bcs if -inf is returned then 0 would be max and add 0 to non empty subseq 
        int skip1=maxdot(n1,n2,i+1,j,dp);
        int skip2=maxdot(n1,n2,i,j+1,dp);

        return dp[i][j]=Math.max(take,Math.max(skip1,skip2));
    }
}