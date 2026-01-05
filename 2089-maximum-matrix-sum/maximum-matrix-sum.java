class Solution {
    public long maxMatrixSum(int[][] matrix) {
        boolean zero=false;
        long sum=0,neg=0,min=Long.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0)  neg++;
                else if(matrix[i][j]==0)  zero=true;
                sum+=(Math.abs(matrix[i][j]));
                min=Math.min(min,(Math.abs(matrix[i][j])));
            }
        }
        if(neg%2==0||zero)  return sum; //if neg%2==0 i.e. thwy can be positive and no negative ele 
        return sum-2*min; // min=1 so 18-2*min--> in 2nd sample tc
    }
}
//Maximize the sum by making all numbers positive; if the count of negatives is odd and there’s no zero, subtract twice the smallest absolute value.