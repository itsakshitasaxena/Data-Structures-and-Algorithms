class Solution {
    List<List<Integer>> adj;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans=new ArrayList<>();
         adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)  adj.add(new ArrayList<>());
        for(int[] a:prerequisites)    adj.get(a[0]).add(a[1]);
        
        Boolean[][] dp=new Boolean[numCourses][numCourses];
        for(int[] q:queries)
            ans.add(dfs(q[0], q[1],new boolean[numCourses],dp));
        
        return ans;
    }
    public boolean dfs(int src, int dest,boolean[] vis, Boolean[][] dp){
        if(src==dest)  return true;
        vis[src]=true;
        if(dp[src][dest]!=null)  return dp[src][dest];
        for(int nbrs:adj.get(src)){
            if(!vis[nbrs]){
                if(dfs(nbrs,dest,vis,dp)) return dp[src][dest]= true;
            }
        }
        return dp[src][dest]=false;
    }
}