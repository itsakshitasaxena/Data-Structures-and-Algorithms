class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length,maxeff=0;
        boolean[][] vis=new boolean[heights.length][heights[0].length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[]curr= pq.poll();
            maxeff=Math.max(maxeff,curr[2]);
            if(curr[0]==n-1&&curr[1]==m-1)  return maxeff;
            if(vis[curr[0]][curr[1]]) continue;
            vis[curr[0]][curr[1]]=true;
            int r=curr[0],c=curr[1];
            for(int[] moves:dir){
                int nr=r+moves[0],nc=c+moves[1];
                if(nr<0||nc<0||nr>=n||nc>=m||vis[nr][nc]) continue;
                int diff=Math.abs(heights[nr][nc]-heights[curr[0]][curr[1]]);
                pq.add(new int[]{nr,nc,diff});
            }
        }
        return maxeff;
    }
}