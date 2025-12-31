class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int n=grid.size(), m=grid.get(0).size();
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[2]-a[2]);
        health=health-grid.get(0).get(0);
        pq.add(new int[]{0,0,health});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(vis[cur[0]][cur[1]]) continue;
            vis[cur[0]][cur[1]]=true;
            if(cur[0]==n-1&&cur[1]==m-1&&health>=1)  return true;
            for(int[] move:dir){
                int r=cur[0]+move[0], c=cur[1]+move[1];
                if(r<0||r>=n||c<0||c>=m||vis[r][c])  continue;
                int h=cur[2]-grid.get(r).get(c);
                if(h>=1)  pq.add(new int[]{r,c,h});
            }
        }
        return false;
    }
}