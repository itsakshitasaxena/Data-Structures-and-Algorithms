class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n];
        Arrays.fill(color,-1);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)   adj.add(new ArrayList<>());
        for(int[] d:dislikes){
            adj.get(d[0]-1).add(d[1]-1);
            adj.get(d[1]-1).add(d[0]-1);
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(adj,color,i,1))  return false;
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj, int[] color, int i, int parentcolor){
        if(color[i]==parentcolor)  return false;
        if(color[i]!=-1) return true;
        color[i]=1-parentcolor;
        for(int nbr:adj.get(i)){
            if(!dfs(adj,color,nbr,color[i]))  return false;
        }
        return true;
    }
}