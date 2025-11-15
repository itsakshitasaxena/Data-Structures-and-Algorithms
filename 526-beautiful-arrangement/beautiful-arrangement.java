class Solution {
    int cnt=0;
    public int countArrangement(int n) {
        boolean[] vis=new boolean[n+1];
        beautiful(n,1,vis);
        return cnt;
    }
    public void beautiful(int n, int pos, boolean[] vis){
        if(pos>n){
            cnt++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i] && (pos%i==0 || i%pos==0)){
                vis[i]=true;
                beautiful(n,pos+1, vis);
                vis[i]=false;
            }
        }
    }
}