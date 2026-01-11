class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n]; //dist from node 1
        int[] dist2=new int[n]; //dist from node 2
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int mindist=-1, mindist_yet=Integer.MAX_VALUE;
        for(int curr=0; curr<edges.length;curr++){ //current node
            int maxdist= Math.max(dist1[curr],dist2[curr]);
            if(mindist_yet > maxdist){
                mindist=curr; // minDistNode = currNode;
                mindist_yet=maxdist;
            }
        }
        return mindist;
    }
    public void bfs(int startnode, int[] edges, int[] dist){
        Queue<Integer> q=new LinkedList<>();
        q.add(startnode);
        Boolean[] vis=new Boolean[edges.length];
        Arrays.fill(vis, Boolean.FALSE);
        dist[startnode]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            if(vis[node])  continue;
            vis[node]=true;
            int nbr=edges[node];
            if(nbr!=-1 && !vis[nbr]){
                dist[nbr]=1+dist[node];
                q.add(nbr);
            }
        }
    }
}