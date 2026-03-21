class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int start=x, end=x+k-1;
        while(start<end){
            for(int j=y;j<y+k;j++){
                int temp=grid[start][j];
                grid[start][j]=grid[end][j];
                grid[end][j]=temp;
            
            }
            start++; end--;
        }        
        return grid;
    }
}