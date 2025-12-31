class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis=new boolean[n];
        ArrayList<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
            for(int[] a:edges){
                adj.get(a[0]).add(a[1]);
                adj.get(a[1]).add(a[0]);
      }
        if(dfs(adj,vis,source,destination)) return true;
        return false;    
    }
    public boolean dfs(ArrayList<List<Integer>> adj,boolean[] vis, int src, int dest){
        if(src==dest)  return true;
        if(vis[src])   return false;
        vis[src]=true;
        for(int nbrs:adj.get(src)){
            if(!vis[nbrs])
                if(dfs(adj,vis,nbrs,dest))  return true;
        }
        return false;
    }
}