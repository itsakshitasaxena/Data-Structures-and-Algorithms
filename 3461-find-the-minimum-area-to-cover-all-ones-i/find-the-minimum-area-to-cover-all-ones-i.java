class Solution {
    public int minimumArea(int[][] grid) {
        int row_max=0,row_min=grid.length,col_max=0,col_min=grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row_max=Math.max(row_max,i);
                    row_min=Math.min(row_min,i);
                    col_max=Math.max(col_max,j);
                    col_min=Math.min(col_min,j);

                }
            }

        }
        int length=row_max-row_min+1;
        int breadth=col_max-col_min+1;


        return length*breadth;
    }
}