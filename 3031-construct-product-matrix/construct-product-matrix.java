class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[] prod=new int[n*m];
        int[] suffix=new int[n*m];
        int[] prefix=new int[n*m];
        suffix[0]=1;
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
              prod[k++]=grid[i][j]%12345;
        }
        for(int i=1;i<prod.length;i++)
           suffix[i]=(suffix[i-1]%12345*prod[i-1]%12345)%12345;
        
        prefix[prod.length-1]=1;
        for(int i=prod.length-2;i>=0;i--)
            prefix[i]=(prefix[i+1]%12345*prod[i+1]%12345)%12345;
        
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
               {grid[i][j]=(suffix[idx]%12345*prefix[idx]%12345)%12345;
               idx++;}
        }
        return grid;
    }
}