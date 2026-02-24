class Solution {
    int mod=1_000_000_007;
    List<List<int[]>> lst;
    public int countPaths(int n, int[][] roads) {
        lst=new ArrayList<>();
        for(int i=0;i<n;i++)  lst.add(new ArrayList<>());
        for(int[] a:roads){ // adj[u] -> list of {v, time}
            lst.get(a[0]).add(new int[]{a[1],a[2]});
            lst.get(a[1]).add(new int[]{a[0],a[2]});
        }
        long[] dist=new long[n];//dist[i]= shortest time to reach i
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways=new int[n];//ways[i] = no. of shortest paths to reach i
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)-> Long.compare(a[0],b[0]));
        dist[0]=0;
        ways[0]=1;
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long d=curr[0];
            int node=(int) curr[1];
            if(d>dist[node])  continue;
            for(int[] nbrs:lst.get(node)){
                long newdist=d+nbrs[1];
                int next=nbrs[0];
                if(newdist<dist[next]){
                    dist[next]=newdist;
                    ways[next]=ways[node];
                    pq.offer(new long[]{newdist,next});
                }
                else if(newdist==dist[next]){
                    ways[next]=(ways[next]+ways[node])%mod;
                } //next ways can be find out 

            }
        }
        return (int) (ways[n-1]%mod);
    }
}