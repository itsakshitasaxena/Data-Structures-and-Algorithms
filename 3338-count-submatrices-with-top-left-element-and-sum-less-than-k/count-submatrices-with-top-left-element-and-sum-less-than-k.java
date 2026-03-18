class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[] col=new int[grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            int row=0;
            for(int j=0;j<grid[0].length;j++){
                col[j]+=grid[i][j];
                row+=col[j];
                if(row<=k) ans++;
            }
        }
        return ans;
    }
}