class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans=new ArrayList<>();
        if(queries.length==0) return ans;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] courses:prerequisites)
            adj.get(courses[0]).add(courses[1]);

        Boolean[][] dp=new Boolean[numCourses][numCourses];
        for(int[] q:queries){
            ans.add(find(q[0],q[1],new boolean[numCourses],dp,adj));
        }
        return ans;
    }
    public boolean find(int a, int b, boolean[] vis,Boolean[][] dp, List<List<Integer>> adj){
        if(vis[b]) return true;
        if(vis[a]) return false;

        if(dp[a][b]!=null) return dp[a][b];
        for(int nbrs:adj.get(a)){
            if(nbrs==b) return true;
            dp[nbrs][b]=find(nbrs,b,vis,dp,adj);
            if(dp[nbrs][b]) return true;
        }
        return dp[a][b]=false;

    }
}