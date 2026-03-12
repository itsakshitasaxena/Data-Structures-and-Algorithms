class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges,(a,b)->b[2]-a[2]);//sort by strength in dec order for MST
        int lo=0, hi=0, ans=-1;
        for(int[] e:edges)
            hi=Math.max(hi,e[2]*2); //max possible strength after upgrade bcs upgrades double the strength
        while(lo<=hi){  // Binary Search on stability
            int mid=(lo+hi)/2;
            if(ispossible(n,edges,k,mid)){
                ans=mid;
                lo=mid+1; // try larger stability(maximising)
            }
            else hi=mid-1;
        }
        return ans;
    }

    public boolean ispossible(int n,int[][] edges,int k, int mid){ // this fn checks if spanning tree  is possible with min strength >= mid
        DSU dsu=new DSU(n);
        int edges_used=0;
        // STEP 1: add must edges
        for(int[] e:edges){
            int u=e[0], v=e[1];
            int strength=e[2], must=e[3];
            if(must==1){
                if(strength<mid) // must edges cannot be upgraded
                     return false; 
                if(!dsu.union(u,v)) return false;
                edges_used++;
            }
        }
        // STEP 2: process optional edges (sorted strongest first)
        int upgrade_edges=0;
        for(int[] e:edges){
            int u=e[0], v=e[1];
            int strength=e[2], must=e[3];
            if(must==0){
                if(dsu.find(u)==dsu.find(v)) 
                    continue; //here, dsu avoids cycle
                if(strength>=mid){ //edge already strong
                    dsu.union(u,v);//merge set
                    edges_used++;
                }
                else if(2*strength>=mid && upgrade_edges < k){
                    upgrade_edges++;
                    dsu.union(u,v); //merging
                    edges_used++;
                }
            }
        }
        return edges_used==n-1; // spanning tree requires n-1 edges
    }
    class DSU{
        int[] parent;
        public DSU(int n){
            parent=new int[n];
            for(int i=0;i<n;i++)  parent[i]=i; //each node is its own parent
        }
        public int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]); //path compression
            return parent[x];
        }
        public boolean union(int a, int b){
            int par_a=find(a);
            int par_b=find(b);
            if(par_a==par_b)  return false; //already connected--> cycle
            parent[par_b]=par_a;
            return true; //edge added successfully
        }
    }
}