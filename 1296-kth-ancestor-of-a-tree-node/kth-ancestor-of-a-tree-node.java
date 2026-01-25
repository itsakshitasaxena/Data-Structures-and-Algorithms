class TreeAncestor {
    // dp[node][j] = 2^j-th ancestor of 'node'
    // j = 0 → parent
    // j = 1 → grandparent (2 steps)
    // j = 2 → 4 steps, etc.
    int log= 20; // enough for n ≤ 2e5
    int[][]  dp;
    public TreeAncestor(int n, int[] parent) {
        dp= new int[n][log];
        for(int i=0;i<n;i++)
            dp[i][0]=parent[i]; //basecase--> 2^0-th ancestor = direct parent
        
        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){ //To get 2^j-th ancestor: jump 2^(j-1) twice
                if(dp[i][j-1]==-1) 
                    dp[i][j]=-1;// If there is no (2^(j-1))-th ancestor, then higher ancestors don't exist
                
                else
                    dp[i][j]=dp[dp[i][j-1]][j-1];  // parent of parent
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        //Binary Lifting--> Move up using binary representation of k
        // If k = 13 → (1101) then jump 8 + 4 + 1
        for(int j=0;j<log;j++){
            if(((k>>j)&1)==1){ // If j-th bit of k is set, jump 2^j ancestors at once
                node=dp[node][j];
                if(node==-1) return -1;
            }
        }
        return node;
    }
}

//TLE--> using hashMap

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */