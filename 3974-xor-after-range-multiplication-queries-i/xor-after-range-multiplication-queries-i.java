class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int ans=0;
        for(int i=0;i<queries.length;i++){
            int idx=queries[i][0];
            while(idx<=queries[i][1]){
                nums[idx]=(int)(((long)nums[idx]*queries[i][3])%1000000007);
                idx+=queries[i][2];
            }
        }
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }
}