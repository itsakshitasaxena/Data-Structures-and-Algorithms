class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=1;i<=4;i++){ //rotate in 4 dir.n
            if(isequal(mat,target))  return true;
            rotate(mat);
        }
        return false;
    }
    public void rotate(int[][] mat){
        for(int i=0;i<mat.length;i++){ //transpose
            for(int j=i;j<mat[0].length;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<mat.length;i++){
            int j=0, k=mat[0].length-1; //reverse
            while(j<=k){
                int temp=mat[i][j];
                mat[i][j]=mat[i][k];
                mat[i][k]=temp;
                j++;k--;
            }
        }
    }
    public boolean isequal(int[][] mat, int[][] target){ //check if mat gets equal
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=target[i][j])  return false;
            }
        }
        return true;
    }
}