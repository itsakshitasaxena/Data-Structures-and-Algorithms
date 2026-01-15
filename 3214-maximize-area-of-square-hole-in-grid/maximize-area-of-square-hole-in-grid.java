class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hmax=1,vmax=1,hcur=1,vcur=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]==hBars[i-1]+1)  hcur++;
            else hcur=1;
            hmax=Math.max(hmax,hcur);
        }
        for(int j=1;j<vBars.length;j++){
            if(vBars[j]==vBars[j-1]+1)  vcur++;
            else vcur=1;
            vmax=Math.max(vmax,vcur);
        }
        int side=Math.min(hmax,vmax)+1;
        return side*side;
    }
}