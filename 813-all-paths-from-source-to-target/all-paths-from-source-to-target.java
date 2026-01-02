class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>  ans=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        lst.add(0);
        dfs(graph,0,graph.length-1,ans,lst);
        return ans;
    }
        public void dfs(int[][] graph,int src,int des, List<List<Integer>> ans,List<Integer> lst){
        if(src==des){
            ans.add(new ArrayList(lst));
            return;
        }
        for(int path:graph[src]){
            lst.add(path);
            dfs(graph,path,des,ans,lst);
            lst.remove(lst.size()-1);
        }

    }
}