class Solution {
    HashSet<Integer> set=new HashSet<>();
    HashMap<String, Long> dp=new HashMap<>();
    int limit;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        limit=2000+2*b; //upper bound to prevent infinite recursion
        for(int i:forbidden)  set.add(i);
        long ans=min_jumps(a,b,x,0,0);
        return ans>=Integer.MAX_VALUE?-1:(int)ans;
    }
    public long min_jumps(int a, int b, int x, int curr, int c){
        //if c==0 --> jump in any direction:- forward: 1+solve(curr + a, 0)
                                        // Jump backward: 1 + solve(curr - b, 1) 
        // if c==1 --> only only jump forward:-  1+solve(curr + a, 0)

        if(curr==x) return 0; //target reached
        if(curr>limit||curr<0)  return Integer.MAX_VALUE; //out of bound
        if(set.contains(curr)) return Integer.MAX_VALUE; //forbidden positions

        String key=curr+"@"+c; //position & previous jump state (FW/BW)
        if(dp.containsKey(key))  return dp.get(key);
        set.add(curr);

        long ans=Integer.MAX_VALUE;

        //can always go forward (+1 in count)
        ans=Math.min(ans,1+min_jumps(a,b,x,curr+a,0));

        //can jump backward only if--> last jump was (❌) backward && curr-b>=0
        if(c!=1 && curr-b>=0)
            ans=Math.min(ans,1+min_jumps(a,b,x,curr-b,1));
        
        set.remove(curr); //backtracking
        dp.put(key,ans);

        return ans;
    }
}