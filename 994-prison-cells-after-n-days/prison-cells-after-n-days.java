class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = (n-1)%14 +1; 
        for(int i=0;i<n;i++){
            int arr[] = new int[8];
            for(int j=1;j<7;j++){
                if((cells[j-1]==0 && cells[j+1]==0) || (cells[j-1]==1 && cells[j+1]==1)){
                    arr[j] = 1;
                }
            }
            cells = arr;
        }
        
        return cells;
    }
}