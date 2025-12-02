class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis=new boolean[isConnected.length];
        int province=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                dfs(vis,isConnected,i);
                province++;
            }
        }
        return province++;
    }
    public void dfs(boolean[] vis, int[][] ar, int i){
        vis[i]=true;
        for(int j=0;j<ar.length;j++){
            if(ar[i][j]==1&&!vis[j]){
                dfs(vis,ar,j);
            }
        }
    }
}