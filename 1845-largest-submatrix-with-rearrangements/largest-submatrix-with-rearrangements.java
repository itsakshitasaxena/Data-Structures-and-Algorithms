class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int[] height=new int[matrix[0].length];
        int max=0, n=matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1) height[j]++;
                else height[j]=0;
            }
            int[] row=height.clone(); // built histogram at each row
            Arrays.sort(row); //sort and tried all widths
            for(int j=n-1;j>=0;j--){
                int length=row[j], width=n-j;
                max=Math.max(max,length*width);
            }
        }
        return max;
    }
}