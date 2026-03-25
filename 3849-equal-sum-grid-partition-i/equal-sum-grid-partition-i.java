class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)  sum+=grid[i][j];
        }
        if(sum%2!=0)   return false;
        long[] horsum=new long[grid.length];
        long[] versum=new long[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) horsum[i]+=grid[i][j];
        }
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++) versum[j]+=grid[i][j];
        }
        
        long hs=0,vs=0;
        for(int i=0;i<grid.length-1;i++){
            hs+=horsum[i];
            if(hs==sum/2) return true;
        }
        for(int i=0;i<grid[0].length-1;i++){
            vs+=versum[i];
            if(vs==sum/2) return true;
        }
        return false;        
    }
}