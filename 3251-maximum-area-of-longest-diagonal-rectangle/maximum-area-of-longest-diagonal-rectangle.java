class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max=0, dig=0;
        for(int i=0;i<dimensions.length;i++){
            int len=dimensions[i][0];
            int wid=dimensions[i][1];
            int area=len*wid;
            int diag=(len*len)+(wid*wid);
            // int diag=(int)(Math.sqrt(area));
            if(diag>dig){
                dig=diag;
                max=area;
            }
            else if(diag==dig){
                max=Math.max(max,area);
            }
            
        }
        return max;
    }
}