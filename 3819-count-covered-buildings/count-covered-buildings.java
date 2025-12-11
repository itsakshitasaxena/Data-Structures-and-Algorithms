class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
    //column y → smallest x (minr[y]), largest x (maxr[y])
    //row x → smallest y (minc[x]), largest y (maxc[x])

        int[] minr=new int[n+1];
        int[] minc=new int[n+1];
        int[] maxr=new int[n+1];
        int[] maxc=new int[n+1];
        Arrays.fill(minr, Integer.MAX_VALUE);
        Arrays.fill(minc, Integer.MAX_VALUE);
        for(int [] a:buildings){
            int x=a[0],y=a[1];
            minr[y]=Math.min(minr[y],x); //keeps min row in column y
            maxr[y]=Math.max( maxr[y],x); 
            minc[x]=Math.min(minc[x],y); //keeps max col in row x
            maxc[x]=Math.max(maxc[x],y);
        }
        int cnt=0;
        for(int[] i:buildings){
            int x=i[0], y=i[1];
            if(x>minr[y]&&x<maxr[y] && y>minc[x]&&y<maxc[x]){    
                cnt++; //i.e.fulfilling all conditions
                // x > minr[y] (has someone above)
                // x < maxr[y] (has someone below)
                // y > minc[x] (has someone left)
                // y < maxc[x] (has someone right)
            }
        }
        return cnt;
    }
}