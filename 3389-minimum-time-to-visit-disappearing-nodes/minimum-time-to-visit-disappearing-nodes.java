class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) { 
            adj.add(new ArrayList<>());
        }
        for(int[] ar:edges){
            adj.get(ar[0]).add(new int[]{ar[1],ar[2]});
            adj.get(ar[1]).add(new int[]{ar[0],ar[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        pq.add(new int[]{0,0});
        boolean[] vis=new boolean[n];
        while(!pq.isEmpty()){
            int[] rp=pq.poll();
            if(vis[rp[0]])  continue;
            vis[rp[0]]=true;
            for(int[] nbrs:adj.get(rp[0])){
                int dist=nbrs[1]+rp[1];
                if(dist<disappear[nbrs[0]]&&dist<=ans[nbrs[0]]){
                    ans[nbrs[0]]=dist;
                    pq.add(new int[]{nbrs[0],dist});
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE)  ans[i]=-1;
        }
        return ans;
    }
}