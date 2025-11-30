class Solution {
    public int longestCycle(int[] edges) {
        int[] in=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1)
                in[edges[i]]++; //indegree of evry node thorugh edges
        }   
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<edges.length;i++){
            if(in[i]==0)
                qu.add(i); 
        }
        boolean[] vis=new boolean[edges.length];
        while(!qu.isEmpty()){ //removing nodes which are not in cycle or 0 indegree
            int r=qu.poll();
            vis[r]=true;
            if(edges[r]!=-1){ 
                in[edges[r]]--;
                if(in[edges[r]]==0)   qu.add(edges[r]);
            }
        }
        int ans=-1;
        for(int i=0;i<edges.length;i++){
            if(vis[i]==false){ //for1st ex-starts from 2
                int cnt=1;
                vis[i]=true;//2 then 3&4 marked as tru in while loop during increment of cnt
                int nbrs=edges[i];
                while(nbrs!=i){
                    cnt++;
                    vis[nbrs]=true;
                    nbrs=edges[nbrs]; //getting connecting edge of nodes
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}